package com.example.gdsc.week5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("/getUltraSrtNcst")
    fun getTodayWeather(
        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: Int = 1,
        @Query("pageNo") pageNo: Int = 1,
        @Query("dataType") dataType: String,
        @Query("base_date") base_date: String,
        @Query("base_time") base_time: String,
        @Query("nx") nx: Int,
        @Query("ny") ny: Int
    ): Call<WeatherDto>
}