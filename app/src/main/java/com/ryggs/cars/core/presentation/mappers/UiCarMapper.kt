package com.ryggs.cars.core.presentation.mappers

import com.ryggs.cars.allcarsfeature.domain.model.UIAllCars
import com.ryggs.cars.core.data.cache.models.allcars.Result
import javax.inject.Inject

// this result input class should ideally live in the domain layer
class UiCarMapper @Inject constructor(): UiMapper<Result, UIAllCars> {

  override fun mapToView(input: Result): UIAllCars {
    return UIAllCars(
        id = input.id,
        name = input.title.toString(),
        photo = input.imageUrl.toString(),
        milage = input.mileage.toString(),
        price = input.marketplacePrice.toString()
    )
  }
}
