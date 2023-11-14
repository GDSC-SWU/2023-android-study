package com.example.gdsc.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseWeatherDto(
    @SerialName("dataType")
    val dataType: String,
    @SerialName("items")
    val items: Items,
    @SerialName("numOfRows")
    val numOfRows: Int,
    @SerialName("pageNo")
    val pageNo: Int,
    @SerialName("totalCount")
    val totalCount: Int
) {
    @Serializable
    data class Items(
        @SerialName("item")
        val item: List<Item>
    ) {
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
    }
}