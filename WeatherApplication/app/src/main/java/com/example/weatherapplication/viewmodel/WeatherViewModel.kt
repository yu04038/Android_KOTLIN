package com.example.weatherapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.data.model.WeatherModel
import com.example.weatherapplication.data.repository.WeatherRepository
import org.json.JSONObject

class WeatherViewModel: ViewModel() {

    private val TAG: String = WeatherViewModel::class.java.simpleName

    private val weatherRepository = WeatherRepository()

    val isSuccWeather = MutableLiveData<Boolean>()
    val responseWeather = MutableLiveData<WeatherModel>()

    fun getWeatherInfoView(jsonObject: JSONObject) {
        Log.d(TAG, "getWeatherInfoView() - jsonObject : " + jsonObject);

        weatherRepository.getWeatherInfo(jsonObject = jsonObject,
            onResponse = {
                if (it.isSuccessful) {
                    Log.d(TAG, "getWeatherInfoView() - Succ : " + it.body());
                    isSuccWeather.value = true
                    responseWeather.value = it.body()
                }
            },
            onFailure = {
                it.printStackTrace()
                Log.d(TAG, "getWeatherInfoView() - Fail : " + it.message);
            }
        )

    }
}