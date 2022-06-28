package com.ryggs.cars.core.data.cache.models.allcars


import com.google.gson.annotations.SerializedName

data class AllCarsResponse(
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("result")
    val result: List<Result>
)