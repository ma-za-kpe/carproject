package com.ryggs.cars.core.data.repository

import com.ryggs.cars.core.data.cache.models.allcars.AllCarsResponse
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.cache.models.carmedia.CarMedia
import com.ryggs.cars.core.data.cache.models.carmedia.CarMediaResponse
import com.ryggs.cars.core.data.cache.models.popularmakes.Make
import com.ryggs.cars.core.data.cache.models.popularmakes.PopularMakeResponse
import io.reactivex.Flowable

interface CarRepository {
    // cars
    suspend fun requestAllCarsNetworkData(): AllCarsResponse
    fun getAllCars(): Flowable<List<Result>>
    suspend fun insertAllCars(cars: List<Result>)

    // detail
    suspend fun requestCarDetailNetworkData(id: String): CarDetailResponse
    fun getCarById(id: String): Flowable<CarDetailResponse>
    suspend fun insertCar(car: CarDetailResponse)

    // make
    suspend fun requestPopularMakeNetworkData(): PopularMakeResponse
    fun getPopularMakes(): Flowable<List<Make>>
    suspend fun insertPopularMakes(make: List<Make>)

    // media
    suspend fun requestCarMediaNetworkData(id: String): CarMediaResponse
    fun getCarMediaById(id: String): Flowable<List<CarMedia>>
    suspend fun insertCarMedia(media: List<CarMedia>)
}