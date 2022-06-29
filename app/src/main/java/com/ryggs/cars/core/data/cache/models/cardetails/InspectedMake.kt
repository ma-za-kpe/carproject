package com.ryggs.cars.core.data.cache.models.cardetails


import com.google.gson.annotations.SerializedName

data class InspectedMake(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("name")
    val name: String?
)