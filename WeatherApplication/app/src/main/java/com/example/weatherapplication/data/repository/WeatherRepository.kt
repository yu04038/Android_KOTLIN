package com.example.weatherapplication.data.repository

import com.example.weatherapplication.data.model.WeatherModel
import com.example.weatherapplication.data.network.RemoteDataSource
import com.example.weatherapplication.data.network.RemoteDataSourceImpl
import org.json.JSONObject
import retrofit2.Response

// ViewModel에서 네트워크 통신을 요청할 때 수행할 함수를 만든다.
class WeatherRepository {

    private val retrofitRemoteDataSource: RemoteDataSource = RemoteDataSourceImpl()
    fun getWeatherInfo(
        jsonObject: JSONObject,
        onResponse: (Response<WeatherModel>) -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        retrofitRemoteDataSource.getWeatherInfo(jsonObject, onResponse, onFailure)
    }

}