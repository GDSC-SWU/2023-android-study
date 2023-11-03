package com.example.gdsc.weather

import kotlinx.serialization.Serializable
@Serializable
data class WeatherDto( val response: Response )
@Serializable
data class Response(
    val header: Header,
    val body: Body
)
@Serializable
data class Header(
    val resultCode : String,
    val resultMsg : String
)
@Serializable
data class Body(
    val dataType: String,
    val items: Items,
    val pageNo: Int,
    val numOfRows: Int,
    val totalCount: Int,
)
@Serializable
data class Items(
    val item: List<Item>
)
@Serializable
data class Item(
    val baseDate: String,
    val baseTime: String,
    val category: String,
    val nx: Int,
    val ny: Int,
    val obsrValue: String
)
