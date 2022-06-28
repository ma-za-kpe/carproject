package com.ryggs.cars.core.data.cache.models.popularmakes


import com.google.gson.annotations.SerializedName

data class PopularMakeResponse(
    @SerializedName("makeList")
    val makeList: List<Make>,
    @SerializedName("pagination")
    val pagination: Pagination
)