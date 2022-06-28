package com.ryggs.cars.allcarsfeature.domain.usecase

import com.ryggs.cars.core.data.repository.CarRepository
import javax.inject.Inject

class GetAllCars @Inject constructor(
    private val repo: CarRepository
) {
    operator fun invoke() = repo.getAllCars()
}