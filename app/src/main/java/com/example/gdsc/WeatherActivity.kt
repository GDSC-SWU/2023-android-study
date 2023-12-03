package com.example.gdsc

import android.os.Bundle
import android.util.Log

class WeatherActivity {
    private lateinit var binding: ActivityWeatherBinding
    private val getWeatherService = WeatherServicePool.getWeather
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getWeatherApi()
    }
    private fun getTodoApi() {
        getWeatherService.getWeather().enqueue(object : retrofit2.Callback<List<WeatherDto>> {
            override fun onResponse(
                call: Call<List<WeatherDto>>, response: Response<List<WeatherDto>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { Log.d("result", it.toString()) }
                } else {
                    Log.d("error", "실패한 응답")
                }
            }

            override fun onFailure(call: Call<List<WeatherDto>>, t: Throwable) {
                t.message?.let { Log.d("error", it) } ?: "서버통신 실패(응답값 X)"
            }
        })
    }
}