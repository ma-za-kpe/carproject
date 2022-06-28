package com.ryggs.cars.popularmakesfeature.presentation

sealed class AllCarCategoryEvent {
  object RequestInitialCarsList: AllCarCategoryEvent()
}