package com.example.gdsc.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gdsc.R
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeatherActivity : AppCompatActivity() {

    private val getWeatherService = ServicePool.getTodayWeather


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        getWeatherrApi()
    }

    private fun getWeatherrApi() {
        val todayDate: LocalDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val formatted_td = todayDate.format(formatter)

        getWeatherService.getTodayWeather(
            "xchJvCufUN4CvhDfeaLEU1rLlup%2B4jNH9RSALuQi97KuXpkVWZtPjHK7KUbEoHhWZ5gTmz2xOdtdgbFrpfP7Qg",
            1,
            1,
            "JSON",
            formatted_td.toString(),
            "0600",
            55,
            127,
        ).enqueue(object : retrofit2.Callback<WeatherDto> {
            override fun onResponse(
                call: Call<WeatherDto>, response: Response<WeatherDto>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.d("api_result", it.toString())
                    }
                } else {
                    Log.d("error", "실패한 응답")
                }
            }

            override fun onFailure(call: Call<WeatherDto>, t: Throwable) {
                t.message?.let { Log.d("error", it) } ?: "서버통신 실패(응답값 X)"
            }
        })
    }
}