package com.ryggs.cars.allcarsfeature.presentation

import com.ryggs.cars.allcarsfeature.domain.model.UIAllCars
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.presentation.Event


// this is the class that stores the current state of your View.
data class AllCarsViewState(
    // list
    val loading: Boolean = true,
    val cars: List<UIAllCars> = emptyList(),

    // Using Event prevents your app from handling the error more than once.
    val failure: Event<Throwable>? = null
)