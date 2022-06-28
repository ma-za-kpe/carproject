package com.ryggs.cars.core.data.cache.models.cardetails


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("mediaType")
    val mediaType: String,
    @SerializedName("url")
    val url: String
)