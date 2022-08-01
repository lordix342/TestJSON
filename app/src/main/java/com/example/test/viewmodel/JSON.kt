package com.example.test.viewmodel

import android.content.Context
import com.example.test.model.ModelJSONItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class JSON {
    fun getter(context: Context, name: String):ArrayList<ModelJSONItem> {
        val inputStream = context.resources.assets.open(name).bufferedReader().use { it.readText() }
        val gson = Gson()
        val arrayModelType = object : TypeToken<ArrayList<ModelJSONItem>>() {}.type
        return gson.fromJson(inputStream, arrayModelType)
    }
}