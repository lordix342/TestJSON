package com.example.test.model


import com.google.gson.annotations.SerializedName

data class Birth(
    @SerializedName("date")
    val date: String,
    @SerializedName("death")
    val death: Death?,
    @SerializedName("location")
    val location: LocationX
)