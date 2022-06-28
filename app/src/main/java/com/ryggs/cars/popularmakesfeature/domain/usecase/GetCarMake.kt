package com.ryggs.cars.popularmakesfeature.domain.usecase

import com.ryggs.cars.core.data.repository.CarRepository
import javax.inject.Inject

class GetPopularCarMake @Inject constructor(
    private val repo: CarRepository
) {
    operator fun invoke() = repo.getPopularMakes()
}