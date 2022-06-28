package com.ryggs.cars.allcarsfeature.domain.usecase

import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.repository.CarRepository
import javax.inject.Inject

class RequestNetworkData @Inject constructor(
    private val repo: CarRepository
) {
    suspend operator fun invoke(): List<Result> {
        val cars = repo.requestAllCarsNetworkData().result

        // caching happens here
        repo.insertAllCars(cars)
        return cars
    }
}