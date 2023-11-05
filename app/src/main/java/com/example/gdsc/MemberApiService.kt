package com.example.gdsc

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MemberApiService {
    @GET("getUltraSrtNcst?serviceKey=IqVvPpU%2BF978g9EmI5OKfapy9GsFWMo%2F6kpq2NoOoeZvibCCxmdMpzBXKujzEON3%2F2i4%2FDa1trld4oEEb84y7w%3D%3D")
    fun getMember(
        @Query("numOfRows") numOfRows: Int = 1,
        @Query("pageNo") pageNo: Int = 1,
        @Query("dataType") dataType: String = "JSON",
        @Query("base_date") base_date: String = "20231105",
        @Query("base_time") base_time: String = "0600",
        @Query("nx") nx: Int = 55,
        @Query("ny") ny: Int = 127
    ): Call<MemberDto>
}