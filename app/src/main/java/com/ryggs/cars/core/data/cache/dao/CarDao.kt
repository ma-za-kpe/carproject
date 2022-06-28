package com.ryggs.cars.core.data.cache.dao

import androidx.room.*
import com.ryggs.cars.core.data.cache.models.allcars.Result
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.cache.models.carmedia.CarMedia
import com.ryggs.cars.core.data.cache.models.popularmakes.Make
import io.reactivex.Flowable

@Dao
interface CarDao {
    // get all cars
    @Transaction
    @Query("SELECT * FROM allcars")
    fun getAllCars(): Flowable<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCars(
        cars: List<Result>
    )

    // get car by id
    @Transaction
    @Query("SELECT * FROM details WHERE id=:id")
    fun getCarById(id: String): Flowable<CarDetailResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCar(
        car: CarDetailResponse
    )

    // get popular makes
    @Transaction
    @Query("SELECT * FROM make")
    fun getPopularMakes(): Flowable<List<Make>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMakes(
        make: List<Make>
    )

    // get car media
    @Transaction
    @Query("SELECT * FROM media WHERE id=:id")
    fun getCarMediaById(id: String): Flowable<List<CarMedia>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarMedia(
        car: List<CarMedia>
    )
}