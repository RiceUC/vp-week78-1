package com.clarice.week78_1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {
    // when search icon is clicked, it will get data from Retrofit.
    fun getData(location:String) {
        Log.i("City name : ", location)
    }
}