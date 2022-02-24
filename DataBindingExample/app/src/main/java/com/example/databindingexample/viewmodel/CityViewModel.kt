package com.example.databindingexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databindingexample.model.City

class CityViewModel: ViewModel() {

    private val cityData = MutableLiveData<City>()
}