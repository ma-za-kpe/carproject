package com.ryggs.cars.carmediafeature.domain.usecase

import com.ryggs.cars.core.data.repository.CarRepository
import javax.inject.Inject

class GetCarMedia @Inject constructor(
    private val repo: CarRepository
) {
    operator fun invoke(id: String) = repo.getCarMediaById(id)
}