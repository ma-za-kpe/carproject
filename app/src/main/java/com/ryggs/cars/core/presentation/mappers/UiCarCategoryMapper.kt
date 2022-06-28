package com.ryggs.cars.core.presentation.mappers

import com.ryggs.cars.allcarsfeature.domain.model.UIAllCars
import com.ryggs.cars.allcarsfeature.domain.model.UICarCategory
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.popularmakes.Make
import javax.inject.Inject

// this result input class should ideally live in the domain layer
class UiCarCategoryMapper @Inject constructor(): UiMapper<Make, UICarCategory> {

  override fun mapToView(input: Make): UICarCategory {
    return UICarCategory(
        id = input.id.toString(),
        name = input.name,
        photo = input.imageUrl
    )
  }
}
