package com.ryggs.cars.popularmakesfeature.presentation

import com.ryggs.cars.allcarsfeature.domain.model.UICarCategory
import com.ryggs.cars.core.presentation.Event


// this is the class that stores the current state of your View.
data class AllCarCategoryViewState(
    // list
    val loading: Boolean = true,
    val cars: List<UICarCategory> = emptyList(),

    // Using Event prevents your app from handling the error more than once.
    val failure: Event<Throwable>? = null
)