package com.example.test.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test.model.ModelJSONItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch

class TestViewModel(application: Application): AndroidViewModel(application) {
    private var _arrayPerson = MutableLiveData<ArrayList<ModelJSONItem>>()
    val personForDetail = MutableLiveData<ModelJSONItem>()
    val arrayPersons : LiveData<ArrayList<ModelJSONItem>>
        get() = _arrayPerson


    init {
        getList(application.applicationContext)
    }

    private fun getList(context: Context) {
        viewModelScope.launch {
            val inputStream = context.resources.assets.open("data.json").bufferedReader().use { it.readText() }
            val gson = Gson()
            val arrayModelType = object : TypeToken<ArrayList<ModelJSONItem>>() {}.type
            _arrayPerson.value = gson.fromJson(inputStream, arrayModelType)
        }
    }
    fun sendPerson(person:ModelJSONItem) {
        viewModelScope.launch {
            personForDetail.value = person
        }
    }
}