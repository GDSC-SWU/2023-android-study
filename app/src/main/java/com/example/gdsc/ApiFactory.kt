package com.example.gdsc

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiFactory {
    private const val BASE_URL =
        "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}

object ServicePool {
    val getMember = ApiFactory.retrofit.create(MemberApiService::class.java)
}