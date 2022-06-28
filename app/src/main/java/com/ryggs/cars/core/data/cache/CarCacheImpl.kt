package com.ryggs.cars.core.data.cache

import com.ryggs.cars.core.data.cache.dao.CarDao
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.cache.models.carmedia.CarMedia
import com.ryggs.cars.core.data.cache.models.popularmakes.Make
import io.reactivex.Flowable
import javax.inject.Inject

class CarCacheImpl @Inject constructor(
    private val carDao: CarDao
) : CarCache {
    override fun getAllCars(): Flowable<List<Result>> {
        return carDao.getAllCars()
    }

    override suspend fun insertAllCars(cars: List<Result>) {
        carDao.insertAllCars(cars)
    }

    override fun getCarById(id: String): Flowable<CarDetailResponse> {
        return carDao.getCarById(id)
    }

    override suspend fun insertCar(car: CarDetailResponse) {
        carDao.insertCar(car)
    }

    override fun getPopularMakes(): Flowable<List<Make>> {
        return carDao.getPopularMakes()
    }

    override suspend fun insertPopularMakes(make: List<Make>) {
        return carDao.insertPopularMakes(make)
    }

    override fun getCarMediaById(id: String): Flowable<List<CarMedia>> {
        return carDao.getCarMediaById(id)
    }

    override suspend fun insertCarMedia(media: List<CarMedia>) {
        return carDao.insertCarMedia(media)
    }
}