package com.example.gdsc.bottomnavigation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gdsc.data.ServicePool
import com.example.gdsc.data.dto.ResponseWeatherDto
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _getWeather: MutableLiveData<ResponseWeatherDto?> = MutableLiveData()
    val getWeather: MutableLiveData<ResponseWeatherDto?> = _getWeather

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        runCatching {
            ServicePool.getWeather.getWeather()
        }.fold({
            _getWeather.value = it.response.body
        }, {
            Log.d("error", it.message.toString())
        })

    }
}