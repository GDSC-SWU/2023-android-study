package com.example.gdsc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    @SerialName("response")
    val response: ResponseDto
)

@Serializable
data class ResponseDto(
    @SerialName("header")
    val header: HeaderDto,
    @SerialName("body")
    val body: BodyDto
)
@Serializable
data class HeaderDto(
    @SerialName("resultCode")
    val resultCode: Int,
    @SerialName("resultMsg")
    val resultMsg: String
)

@Serializable
data class BodyDto(
    @SerialName("dataType")
    val dataType: String,
    @SerialName("items")
    val items: ItemDto,
    @SerialName("pageNo")
    val pageNo: Int,
    @SerialName("numOfRows")
    val numOfRows: Int,
    @SerialName("totalCount")
    val totalCount: Int,
)

@Serializable
data class ItemDto(
    @SerialName("base_date")
    val base_date: Int,
    @SerialName("base_time")
    val base_time: Int,
    @SerialName("category")
    val category: String,
    @SerialName("nx")
    val nx: Int,
    @SerialName("ny")
    val ny: Int,
    @SerialName("obsrValue")
    val obsrValue: String
)
