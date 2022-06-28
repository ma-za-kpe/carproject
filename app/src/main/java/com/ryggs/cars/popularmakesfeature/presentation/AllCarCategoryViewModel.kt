package com.ryggs.cars.popularmakesfeature.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryggs.cars.core.data.cache.models.popularmakes.Make
import com.ryggs.cars.core.data.remote.interceptors.NetworkException
import com.ryggs.cars.core.presentation.Event
import com.ryggs.cars.core.presentation.mappers.UiCarCategoryMapper
import com.ryggs.cars.core.utils.createExceptionHandler
import com.ryggs.cars.popularmakesfeature.domain.usecase.GetPopularCarMake
import com.ryggs.cars.popularmakesfeature.domain.usecase.RequestNetworkData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllCarCategoryViewModel @Inject constructor(
    private val getCachedAllCars: GetPopularCarMake,
    private val uiCarMapper: UiCarCategoryMapper,
    private val requestNetworkData: RequestNetworkData,
    private val compositeDisposable: CompositeDisposable,
): ViewModel(){
    val state: LiveData<AllCarCategoryViewState> get() = _state
    private val _state = MutableLiveData<AllCarCategoryViewState>()

    init {
        _state.value = AllCarCategoryViewState()
        subscribeToAllcarsDbUpdates()
    }

    fun onEvent(event: AllCarCategoryEvent) {
        when(event) {
            is AllCarCategoryEvent.RequestInitialCarsList -> loadNetworkCars()
        }
    }

    private fun loadNetworkCars() {
        if (state.value!!.cars.isEmpty()) {
            Log.d("vm", "called cars category ${state.value?.cars?.size}")
            _state.value = state.value!!.copy( loading = true)
            val errorMessage = "Failed to fetch rides: "
            val exceptionHandler = viewModelScope.createExceptionHandler(errorMessage){
                onFailure(it)
            }
            viewModelScope.launch(exceptionHandler) {
                delay(3000)
                requestNetworkData()
                _state.value = state.value!!.copy( loading = false)
            }
        }
    }

    private fun subscribeToAllcarsDbUpdates() {
        getCachedAllCars()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { onRides(it) },
                { onFailure(it) }
            )
            .addTo(compositeDisposable)
    }

    private fun onRides(it: List<Make>) {
        val cars = it.map { uiCarMapper.mapToView(it) }
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