package com.ryggs.cars.core.data.cache.models.cardetails


import com.google.gson.annotations.SerializedName

data class InspectionItem(
    @SerializedName("comment")
    val comment: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("medias")
    val medias: List<Media>,
    @SerializedName("name")
    val name: String,
    @SerializedName("response")
    val response: String
)