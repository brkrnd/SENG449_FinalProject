package com.example.seng449_finalproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seng449_finalproject.model.Weather
import com.example.seng449_finalproject.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel

@Inject
constructor(private val repository: WeatherRepository) : ViewModel(){

    private val resp = MutableLiveData<Weather>()
    val weatherResponse: LiveData<Weather>

    get() = resp

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        repository.getWeather().let { response ->
            if (response.isSuccessful){
                resp.postValue(response.body())
            } else {
                Log.d("TAG", "getWeather Error: ${response.message()}")
            }
        }
    }

}