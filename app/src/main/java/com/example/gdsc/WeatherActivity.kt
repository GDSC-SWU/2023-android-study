package com.example.gdsc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gdsc.databinding.ActivityWeatherBinding
import retrofit2.Call
import retrofit2.Response

class WeatherActivity : AppCompatActivity() {
    private lateinit var weatherBinding: ActivityWeatherBinding
    private val getWeatherService = WeatherServicePool.getWeather
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherBinding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(weatherBinding.root)
        getWeatherApi()
    }
    private fun getWeatherApi() {
        getWeatherService.getWeather().enqueue(object : retrofit2.Callback<WeatherDTO> {
            override fun onResponse(
                call: Call<WeatherDTO>, response: Response<WeatherDTO>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        weatherBinding.tvLog.text = response.body().toString()
                        Log.d("result", it.toString())
                    }
                } else {
                    Log.d("error", "실패한 응답")
                }
            }

            override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
                t.message?.let { Log.d("error", it) } ?: "서버통신 실패(응답값 X)"
            }
        })
    }
}