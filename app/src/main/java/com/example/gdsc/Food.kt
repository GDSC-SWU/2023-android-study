package com.example.gdsc

import androidx.annotation.DrawableRes

data class Food(
    @DrawableRes
    val img : Int,
    val name: String,
    val type : String,
    val price : String
)
