package com.ryggs.cars.core.data.cache

import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.cache.models.carmedia.CarMedia
import com.ryggs.cars.core.data.cache.models.popularmakes.Make
import io.reactivex.Flowable

interface CarCache {

    // cars
    fun getAllCars(): Flowable<List<Result>>
    suspend fun insertAllCars(cars: List<Result>)

    // detail
    fun getCarById(id: String): Flowable<CarDetailResponse>
    suspend fun insertCar(car: CarDetailResponse)

    // make
    fun getPopularMakes(): Flowable<List<Make>>
    suspend fun insertPopularMakes(make: List<Make>)

    // media
    fun getCarMediaById(id: String): Flowable<List<CarMedia>>
    suspend fun insertCarMedia(media: List<CarMedia>)

}