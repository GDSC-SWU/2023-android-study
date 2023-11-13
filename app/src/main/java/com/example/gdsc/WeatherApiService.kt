package com.example.gdsc

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("getUltraSrtNcst?serviceKey=Hz43%2FMh9cPK9LXQADpM12FtbTkugl4sCSu42kuk%2F%2BKQdx9EzFNhjmMevlwqfKXfcBB6a61xx97buoKe4f9OYHg%3D%3D")
    fun getWeather(
        @Query("numOfRows") numOfRows: Int = 1,
        @Query("pageNo") pageNo: Int = 1,
        @Query("dataType") dataType: String = "JSON",
        @Query("baseDate") baseDate: String = "20231113",
        @Query("baseTime") baseTime: String = "0600",
        @Query("nx") nx: Int = 55,
        @Query("ny") ny: Int = 127
    ): Call<WeatherDTO>
}


