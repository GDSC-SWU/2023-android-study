package com.example.gdsc

import retrofit2.Call
import retrofit2.http.GET

interface MemberApiService {
    @GET("member.json")
    fun getMember(): Call<List<MemberDto>>
}