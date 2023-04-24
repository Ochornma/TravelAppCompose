package com.example.travelappcompose.home.model

import androidx.annotation.DrawableRes

data class Destination(
    val name: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    @DrawableRes
    val imageName: Int
)
