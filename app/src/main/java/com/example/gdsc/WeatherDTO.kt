package com.example.gdsc
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class WeatherDTO(
    @SerialName("response")
    val response: Response
)
    @Serializable
    data class Response(
        @SerialName("header")
        val header: Header,
        @SerialName("body")
        val body: Body
)
    @Serializable
    data class Header(
        @SerialName("resultCode")
        val resultCode: String,
        @SerialName("resultMsg")
        val resultMsg: String
    )
    @Serializable
    data class Body(
        @SerialName("dataType")
        val dataType: String,
        @SerialName("items")
        val items: Items,
        @SerialName("pageNo")
        val pageNo: Int,
        @SerialName("numOfRows")
        val numOfRows: Int,
        @SerialName("totalCount")
        val totalCount: Int
    )
    @Serializable
    data class Items(
        @SerialName("item")
        val item: List<Item>
    )
    @Serializable
    data class Item(
        @SerialName("baseDate")
        val baseDate: String,
        @SerialName("baseTime")
        val baseTime: String,
        @SerialName("category")
        val category: String,
        @SerialName("nx")
        val nx: Int,
        @SerialName("ny")
        val ny: Int,
        @SerialName("obsrValue")
        val obsrValue: String
    )
