package com.ryggs.cars.core.data.cache.models.carmedia


import com.google.gson.annotations.SerializedName

data class CarMediaResponse(
    @SerializedName("carMediaList")
    val carMediaList: List<CarMedia>,
    @SerializedName("pagination")
    val pagination: Pagination
)