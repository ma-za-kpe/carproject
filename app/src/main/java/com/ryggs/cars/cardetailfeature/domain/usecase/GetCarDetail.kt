package com.ryggs.cars.cardetailfeature.domain.usecase

import com.ryggs.cars.core.data.repository.CarRepository
import javax.inject.Inject

class GetCarDetail @Inject constructor(
    private val repo: CarRepository
) {
    operator fun invoke(id: String) = repo.getCarById(id)
}