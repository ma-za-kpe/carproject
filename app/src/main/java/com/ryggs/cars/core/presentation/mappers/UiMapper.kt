package com.ryggs.cars.core.presentation.mappers

interface UiMapper<E, V> {

  fun mapToView(input: E): V
}