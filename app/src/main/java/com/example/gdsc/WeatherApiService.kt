package com.example.gdsc

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("/getUltraSrtNcst")
    fun getUltraSrtNcst(
        @Query("serviceKey") serviceKey: String = "YvHwazkj0CT00f2zDT9k3SW58W2KV4CVXA8%2BSopQPtYEMumI5QhItSGGbFMlCjruiZiFsS4nYcB0Oxfm2%2BKw3Q%3D%3D",
        @Query("numOfRows") numOfRows : Int = 1,
        @Query("pageNo") pageNo : Int = 1,
        @Query("dataType") dataType : String = "JSON",
        @Query("base_date") base_date : Int = 20231113,
        @Query("base_time") base_time : Int = 0600,
        @Query("nx") nx : Int = 55,
        @Query("ny") ny : Int = 127
    ): Call<List<WeatherDto>>
}

interface WeatherApiService {
    @GET("/getUltraSrtNcst?serviceKey=YvHwazkj0CT00f2zDT9k3SW58W2KV4CVXA8")
    fun getWeather(): Call<List<WeatherDto>>
}