package com.example.weatherapplication.data.network

import com.example.weatherapplication.data.model.WeatherModel
import org.json.JSONObject
import retrofit2.Response

interface RemoteDataSource {

    fun getWeatherInfo(
        jsonObject: JSONObject,
        onResponse: (Response<WeatherModel>) -> Unit,
        onFailure: (Throwable) -> Unit
    )
}