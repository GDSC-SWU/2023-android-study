package com.example.gdsc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemberDto(
    @SerialName("img")
    val image: String,
    @SerialName("name")
    val name: String
)
