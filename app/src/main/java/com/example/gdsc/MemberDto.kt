package com.example.gdsc

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable //데이터들을 직렬화하기 위한 어노테이션. 직렬화: 객체를 전송 가능한 형태로 만들어주는 것
data class MemberDto(
    @SerialName("img")
    val image: String,
    @SerialName("name")
    val name: String
)