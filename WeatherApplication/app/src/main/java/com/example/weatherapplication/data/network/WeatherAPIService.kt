package com.example.weatherapplication.data.network

import com.example.weatherapplication.data.model.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPIService {
    @GET("data/2.5/{path}")
    fun doGetJsonDataWeather(
        @Path("path") path: String,
        @Query("q") q: String,
        @Query("appid") appid: String,
    ): Call<WeatherModel>
}