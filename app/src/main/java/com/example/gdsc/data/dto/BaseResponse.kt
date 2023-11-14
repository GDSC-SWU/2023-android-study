package com.example.gdsc.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("response")
    val response: Response<T>
) {

    @Serializable
    data class Response<T>(
        @SerialName("header")
        val header: Header,
        @SerialName("body")
        val body: T? = null
    )

    @Serializable
    data class Header(
        @SerialName("resultCode")
        val resultCode: String,
        @SerialName("resultMsg")
        val resultMsg: String
    )
}