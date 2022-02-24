package com.example.databindingexample.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databindingexample.model.City
import com.example.databindingexample.model.CityDataProvider

class CityViewModel: ViewModel() {

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 2000L

    init {
        // CityViewModel이 시작할때 loop을 돌려야 하므로 init을 이용한다.
        loop()
    }

    fun getCityData(): LiveData<City> = cityData

    private fun loop() {
        Handler(Looper.getMainLooper()).postDelayed( {updateCity() }, delay)
    }
    private fun updateCity() {
        currentIndex++
        currentIndex %= cities.size

        cityData.value = cities[currentIndex]

        loop()
    }
}