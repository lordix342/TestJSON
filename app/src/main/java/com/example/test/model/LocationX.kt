package com.example.test.model


import com.google.gson.annotations.SerializedName

data class LocationX(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("name")
    val name: String
)