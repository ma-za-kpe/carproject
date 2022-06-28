package com.ryggs.cars.core.data.cache.models.cardetails


import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("make")
    val make: Make,
    @SerializedName("modelFeatures")
    val modelFeatures: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("popular")
    val popular: Boolean,
    @SerializedName("wheelType")
    val wheelType: String
)