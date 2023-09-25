package com.example.starbucks

import androidx.annotation.DrawableRes

data class Coffee (
    @DrawableRes
    val image: Int,
    val title: String,
    val price: String
)