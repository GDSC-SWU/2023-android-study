package com.example.gdsc.data.api

import com.example.gdsc.BuildConfig.SERVICE_KEY
import com.example.gdsc.data.dto.BaseResponse
import com.example.gdsc.data.dto.ResponseWeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    companion object {
        const val GET_ULTRA_SRT_NCST = "getUltraSrtNcst"
        const val SERVICE_KEY_LABEL = "serviceKey"
        const val NUM_OF_ROWS = "numOfRows"
        const val PAGE_NO = "pageNo"
        const val DATA_TYPE = "dataType"
        const val BASE_DATE = "base_date"
        const val BASE_TIME = "base_time"
        const val NX = "nx"
        const val NY = "ny"
    }

    @GET(GET_ULTRA_SRT_NCST)
    suspend fun getWeather(
        @Query(SERVICE_KEY_LABEL) serviceKey: String = SERVICE_KEY,
        @Query(NUM_OF_ROWS) numOfRows: Int = 1,
        @Query(PAGE_NO) pageNo: Int = 1,
        @Query(DATA_TYPE) dataType: String = "JSON",
        @Query(BASE_DATE) baseDate: String = "20231114",
        @Query(BASE_TIME) baseTime: String = "0600",
        @Query(NX) nx: Int = 55,
        @Query(NY) ny: Int = 127,
    ): BaseResponse<ResponseWeatherDto>
}

