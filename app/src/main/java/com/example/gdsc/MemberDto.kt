package com.example.gdsc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemberDto(
    @SerialName("img")
    val image: Int,
    @SerialName("name")
    val name: String
)