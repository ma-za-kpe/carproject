package com.ryggs.cars.core.data.cache.models.cardetails


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "details")
data class CarDetailResponse(
    @SerializedName("bodyType")
    val bodyType: BodyType,
    @SerializedName("carFeatures")
    val carFeatures: List<Any>,
    @SerializedName("carName")
    val carName: String,
    @SerializedName("ccMeasurement")
    val ccMeasurement: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("damageMedia")
    val damageMedia: List<DamageMedia>,
    @SerializedName("depositReceived")
    val depositReceived: Boolean,
    @SerializedName("engineType")
    val engineType: String,
    @SerializedName("exteriorColor")
    val exteriorColor: String,
    @SerializedName("features")
    val features: List<Any>,
    @SerializedName("financingSettings")
    val financingSettings: FinancingSettings,
    @SerializedName("fuelType")
    val fuelType: String,
    @SerializedName("gradeScore")
    val gradeScore: Double,
    @SerializedName("hasFinancing")
    val hasFinancing: Boolean,
    @SerializedName("hasThreeDImage")
    val hasThreeDImage: Boolean,
    @SerializedName("hasWarranty")
    val hasWarranty: Boolean,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("inspectorDetails")
    val inspectorDetails: InspectorDetails,
    @SerializedName("installment")
    val installment: Int,
    @SerializedName("insured")
    val insured: Boolean,
    @SerializedName("interiorColor")
    val interiorColor: String,
    @SerializedName("isFeatured")
    val isFeatured: Boolean,
    @SerializedName("loanValue")
    val loanValue: Int,
    @SerializedName("marketplaceOldPrice")
    val marketplaceOldPrice: Int,
    @SerializedName("marketplacePrice")
    val marketplacePrice: Int,
    @SerializedName("marketplaceVisible")
    val marketplaceVisible: Boolean,
    @SerializedName("marketplaceVisibleDate")
    val marketplaceVisibleDate: String,
    @SerializedName("mileage")
    val mileage: Int,
    @SerializedName("mileageUnit")
    val mileageUnit: String,
    @SerializedName("model")
    val model: Model,
    @SerializedName("modelFeatures")
    val modelFeatures: List<Any>,
    @SerializedName("ownerType")
    val ownerType: String,
    @SerializedName("sellingCondition")
    val sellingCondition: String,
    @SerializedName("sold")
    val sold: Boolean,
    @SerializedName("state")
    val state: String,
    @SerializedName("transmission")
    val transmission: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("vin")
    val vin: String,
    @SerializedName("websiteUrl")
    val websiteUrl: String,
    @SerializedName("year")
    val year: Int
)