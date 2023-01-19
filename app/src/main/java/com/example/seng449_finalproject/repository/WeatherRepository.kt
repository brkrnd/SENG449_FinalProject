package com.example.seng449_finalproject.repository

import com.example.seng449_finalproject.api.ApiService
import javax.inject.Inject

class WeatherRepository

@Inject
constructor(private val apiService: ApiService){
    suspend fun getWeather() = apiService.getWeather()
}