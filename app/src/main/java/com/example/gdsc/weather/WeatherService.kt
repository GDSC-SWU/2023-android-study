package com.example.gdsc.weather

import com.example.gdsc.weather.ApiKey.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface WeatherService {
    @GET("getUltraSrtNcst?serviceKey=$API_KEY")
    fun getWeather(
        @Query("numOfRows") numOfRows: Int = 1,              // 한 페이지 경과 수
        @Query("pageNo") pageNo: Int = 1,                    // 페이지 번호
        @Query("dataType") dataType: String = "JSON",        // 응답 자료 형식
        @Query("base_date") base_date: String = "20231103",  // 발표 일자
        @Query("base_time") base_time: String = "0600",      // 발표 시각
        @Query("nx") nx: Int = 55,                           // 예보지점 X 좌표
        @Query("ny") ny: Int = 127,                          // 예보지점 Y 좌표
    ): Call<WeatherDto>
}
