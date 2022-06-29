package com.ryggs.cars.allcarsfeature.presentation

sealed class CarDetailsEvent {
  object RequestCarsDetail: CarDetailsEvent()
}