package com.ryggs.cars.core.presentation.mappers

import com.ryggs.cars.allcarsfeature.domain.model.UIAllCars
import com.ryggs.cars.cardetailfeature.domain.UICarDetail
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import javax.inject.Inject

// this result input class should ideally live in the domain layer
class UiCarDetailMapper @Inject constructor(): UiMapper<CarDetailResponse, UICarDetail> {

  override fun mapToView(input: CarDetailResponse): UICarDetail {
    return UICarDetail(
        name = input.carName.toString(),
        photo = input.imageUrl.toString(),
        milage = input.mileage.toString(),
        price = input.marketplacePrice.toString(),
        country = input.country.toString(),
        transmission = input.transmission.toString(),
        engine_type = input.engineType.toString()
    )
  }
}