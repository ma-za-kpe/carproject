package com.ryggs.cars.core.data.cache.models.cardetails


import com.google.gson.annotations.SerializedName

data class DamageMedia(
    @SerializedName("comment")
    val comment: String?,
    @SerializedName("inspectionItems")
    val inspectionItems: List<InspectionItem>?,
    @SerializedName("name")
    val name: String?
)