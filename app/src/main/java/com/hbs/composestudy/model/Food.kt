package com.hbs.composestudy.model

import androidx.annotation.DrawableRes

data class Food(
    @DrawableRes val imageResource: Int,
    val name: String,
    val content: String
)