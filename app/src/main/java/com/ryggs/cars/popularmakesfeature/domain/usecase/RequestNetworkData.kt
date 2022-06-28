package com.ryggs.cars.popularmakesfeature.domain.usecase

import com.ryggs.cars.core.data.cache.models.popularmakes.Make
import com.ryggs.cars.core.data.repository.CarRepository
import javax.inject.Inject

class RequestNetworkData @Inject constructor(
    private val repo: CarRepository
) {
    suspend operator fun invoke(): List<Make> {
        val cars = repo.requestPopularMakeNetworkData().makeList

        // caching happens here
        repo.insertPopularMakes(cars)
        return cars
    }
}