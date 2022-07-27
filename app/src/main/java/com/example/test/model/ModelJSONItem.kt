package com.example.test.model


import com.google.gson.annotations.SerializedName

data class ModelJSONItem(
    @SerializedName("about")
    val about: String,
    @SerializedName("birth")
    val birth: Birth,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("picture")
    val picture: String
)