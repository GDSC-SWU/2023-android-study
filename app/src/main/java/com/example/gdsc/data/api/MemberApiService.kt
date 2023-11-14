package com.example.gdsc.data.api

import com.example.gdsc.data.dto.MemberDto
import retrofit2.Call
import retrofit2.http.GET

interface MemberApiService {
    @GET("member.json")
    fun getMember(): Call<List<MemberDto>>


}