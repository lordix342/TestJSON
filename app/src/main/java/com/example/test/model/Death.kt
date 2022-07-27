package com.example.test.model


import com.google.gson.annotations.SerializedName

data class Death(
    @SerializedName("date")
    val date: String,
    @SerializedName("location")
    val location: LocationX
)