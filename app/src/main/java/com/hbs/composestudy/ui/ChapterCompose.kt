package com.hbs.composestudy.ui

import androidx.compose.runtime.Composable
import com.hbs.composestudy.model.Food

abstract class ChapterCompose{
    @Composable
    abstract fun ContentView(name:String, foodItems: List<Food> = listOf())
}