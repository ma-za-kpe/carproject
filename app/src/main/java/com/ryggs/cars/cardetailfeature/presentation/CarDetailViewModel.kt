package com.ryggs.cars.cardetailfeature.presentation

import android.util.Log
import androidx.lifecycle.*
import com.ryggs.cars.allcarsfeature.presentation.CarDetailsEvent
import com.ryggs.cars.cardetailfeature.domain.usecase.GetCarDetail
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.di.DataStoreRepo
import com.ryggs.cars.core.data.remote.interceptors.NetworkException
import com.ryggs.cars.core.presentation.Event
import com.ryggs.cars.core.presentation.mappers.UiCarDetailMapper
import com.ryggs.cars.core.utils.createExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarDetailViewModel @Inject constructor(
    private val getCachedCar: GetCarDetail,
    private val uiCarMapper: UiCarDetailMapper,
    private val requestNetworkData: com.ryggs.cars.cardetailfeature.domain.usecase.RequestNetworkData,
    private val compositeDisposable: CompositeDisposable,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    val state: LiveData<CarDetailViewState> get() = _state
    private val _state = MutableLiveData<CarDetailViewState>()

    init {
        _state.value = CarDetailViewState()
        val yourArgument: String? = savedStateHandle["id"]
        subscribeToAllcarsDbUpdates(yourArgument.toString())
    }

    fun onEvent(event: CarDetailsEvent, id: String) {
        when(event) {
            is CarDetailsEvent.RequestCarsDetail -> loadNetworkCarDetail(id)
        }
    }

    private fun loadNetworkCarDetail(id: String) {
        if (state.value!!.cars.name.isEmpty()) {
            Log.d("vm", "called carsFromNetwork ${state.value?.cars?.photo}")
            _state.value = state.value!!.copy( loading = true)
            val errorMessage = "Failed to fetch cars: "
            val exceptionHandler = viewModelScope.createExceptionHandler(errorMessage){
                onFailure(it)
            }
            viewModelScope.launch(exceptionHandler) {
                delay(3000)
                requestNetworkData(id)
                _state.value = state.value!!.copy( loading = false)
            }
        }
    }

    fun subscribeToAllcarsDbUpdates(id: String) {
        getCachedCar(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { onRides(it) },
                { onFailure(it) }
            )
            .addTo(compositeDisposable)
    }

    private fun onRides(it: CarDetailResponse) {
        val cars = uiCarMapper.mapToView(it)
        _state.value = state.value!!.copy( loading = true)
        _state.value = state.value!!.copy(loading = false, cars = cars)
    }

    private fun onFailure(failure: Throwable) {
        when (failure) {
            is NetworkException -> {
                _state.value = state.value!!.copy(
                    loading = false,
                    failure = Event(failure)
                )
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}