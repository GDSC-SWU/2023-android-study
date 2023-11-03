package com.example.gdsc.weather

import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
object WeatherApiFactory {
    private const val BASE_URL =
        "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}

object WeatherServicePool {
    val getWeather = WeatherApiFactory.retrofit.create(WeatherService::class.java)
}


