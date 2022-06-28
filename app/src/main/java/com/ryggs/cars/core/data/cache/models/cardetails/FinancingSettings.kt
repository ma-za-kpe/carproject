package com.ryggs.cars.core.data.cache.models.cardetails


import com.google.gson.annotations.SerializedName

data class FinancingSettings(
    @SerializedName("loanCalculator")
    val loanCalculator: LoanCalculator
)