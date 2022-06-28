package com.ryggs.cars.core.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ryggs.cars.core.data.cache.convertor.CarConvertor
import com.ryggs.cars.core.data.cache.dao.CarDao
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.cache.models.carmedia.CarMedia
import com.ryggs.cars.core.data.cache.models.popularmakes.Make

@Database(
    entities = [
        Result::class,
    CarMedia::class,
    CarDetailResponse::class,
    Make::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(CarConvertor::class)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}
