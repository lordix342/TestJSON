package com.example.test.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test.model.ModelJSONItem
import kotlinx.coroutines.launch

class TestViewModel(application: Application): AndroidViewModel(application) {
    private val jSON = JSON()
    private var _arrayPerson = MutableLiveData<ArrayList<ModelJSONItem>>()
    val personForDetail = MutableLiveData<ModelJSONItem>()
    val arrayPersons : LiveData<ArrayList<ModelJSONItem>>
        get() = _arrayPerson

    fun getList(context: Context) {
        viewModelScope.launch {
            _arrayPerson.value = jSON.getter(context, "data.json")
        }
    }
    fun sendPerson(person:ModelJSONItem) {
        viewModelScope.launch {
            personForDetail.value = person
        }
    }
}