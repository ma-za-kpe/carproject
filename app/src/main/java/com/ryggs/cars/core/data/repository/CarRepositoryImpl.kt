package com.ryggs.cars.core.data.repository

import com.ryggs.cars.core.data.cache.CarCache
import com.ryggs.cars.core.data.cache.models.allcars.AllCarsResponse
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.cache.models.carmedia.CarMedia
import com.ryggs.cars.core.data.cache.models.carmedia.CarMediaResponse
import com.ryggs.cars.core.data.cache.models.popularmakes.Make
import com.ryggs.cars.core.data.cache.models.popularmakes.PopularMakeResponse
import com.ryggs.cars.core.data.remote.CarsApi
import io.reactivex.Flowable
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val api: CarsApi,
    private val cache: CarCache
) : CarRepository {
    override suspend fun requestAllCarsNetworkData(): AllCarsResponse {
        return api.getAllCars()
    }

    override fun getAllCars(): Flowable<List<Result>> {
        return cache.getAllCars()
    }

    override suspend fun insertAllCars(cars: List<Result>) {
        cache.insertAllCars(cars)
    }

    override suspend fun requestCarDetailNetworkData(id: String): CarDetailResponse {
        return api.getCarById(id)
    }

    override fun getCarById(id: String): Flowable<CarDetailResponse> {
        return cache.getCarById(id)
    }

    override suspend fun insertCar(car: CarDetailResponse) {
        return cache.insertCar(car)
    }

    override suspend fun requestPopularMakeNetworkData(): PopularMakeResponse {
        return api.getCarMake()
    }

    override fun getPopularMakes(): Flowable<List<Make>> {
        return cache.getPopularMakes()
    }

    override suspend fun insertPopularMakes(make: List<Make>) {
       return cache.insertPopularMakes(make)
    }

    override suspend fun requestCarMediaNetworkData(id: String): CarMediaResponse {
        return api.getCarMedia(id)
    }

    override fun getCarMediaById(id: String): Flowable<List<CarMedia>> {
        return cache.getCarMediaById(id)
    }

    override suspend fun insertCarMedia(media: List<CarMedia>) {
        return cache.insertCarMedia(media)
    }
}