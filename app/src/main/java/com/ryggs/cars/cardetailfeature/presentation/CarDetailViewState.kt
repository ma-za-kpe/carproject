package com.ryggs.cars.cardetailfeature.presentation

import com.ryggs.cars.cardetailfeature.domain.UICarDetail
import com.ryggs.cars.core.presentation.Event

// this is the class that stores the current state of your View.
data class CarDetailViewState(
    // list
    val loading: Boolean = true,
    val cars: UICarDetail = UICarDetail("","","", "","","", ""),

    // Using Event prevents your app from handling the error more than once.
    val failure: Event<Throwable>? = null
)