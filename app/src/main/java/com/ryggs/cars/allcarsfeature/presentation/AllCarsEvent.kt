package com.ryggs.cars.allcarsfeature.presentation

sealed class AllCarsEvent {
  object RequestInitialCarsList: AllCarsEvent()
  object RequestMoreCars: AllCarsEvent()
}