package com.ryggs.cars.cardetailfeature.domain.usecase

import android.util.Log
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.repository.CarRepository
import javax.inject.Inject

class RequestNetworkData @Inject constructor(
    private val repo: CarRepository
) {
    suspend operator fun invoke(id: String): CarDetailResponse {
        val cars = repo.requestCarDetailNetworkData(id)
        Log.d("vm", "called cars ${cars}")

        // caching happens here
        repo.insertCar(cars)
        return cars
    }
}