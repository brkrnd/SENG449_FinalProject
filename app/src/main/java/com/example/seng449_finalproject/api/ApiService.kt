package com.example.seng449_finalproject.api

import com.example.seng449_finalproject.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/Ankara")
    suspend fun getWeather(): Response<Weather>

}