package com.ryggs.cars.core.data.remote

import com.ryggs.cars.core.data.cache.models.allcars.AllCarsResponse
import com.ryggs.cars.core.data.cache.models.cardetails.CarDetailResponse
import com.ryggs.cars.core.data.cache.models.carmedia.CarMediaResponse
import com.ryggs.cars.core.data.cache.models.popularmakes.PopularMakeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CarsApi {

    // get all cars
    // https://api.staging.myautochek.com/v1/inventory/car/search
    @GET("${ApiConstants.CAR_ENDPOINT}/search")
    suspend fun getAllCars(): AllCarsResponse

    // get car detail
    // https://api.staging.myautochek.com/v1/inventory/car/3sF5ITVTC
    @GET("${ApiConstants.CAR_ENDPOINT}/{${ApiParameters.CAR_ID}}")
    suspend fun getCarById(
        @Query(ApiParameters.CAR_ID) id: String,
    ): CarDetailResponse

    // get popular makes
    // https://api.staging.myautochek.com/v1/inventory/make?popular=true
    @GET("${ApiConstants.MAKE_ENDPOINT}?${ApiParameters.POPULAR}=true")
    suspend fun getCarMake(): PopularMakeResponse

    // get car media
    // https://api.staging.myautochek.com/v1/inventory/car_media?carId=3sF5ITVTC
    @GET("${ApiConstants.CAR_MEDIA_ENDPOINT}?{${ApiParameters.CAR_ID}}")
    suspend fun getCarMedia(
        @Query(ApiParameters.CAR_ID) id: String,
    ): CarMediaResponse

}
