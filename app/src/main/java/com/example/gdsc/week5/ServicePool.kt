package com.example.gdsc.week5


object ServicePool {
    val getTodayWeather = ApiFactory.retrofit.create(WeatherApiService::class.java)
}