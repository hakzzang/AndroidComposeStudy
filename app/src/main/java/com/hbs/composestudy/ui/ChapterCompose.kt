package com.hbs.composestudy.ui

import androidx.compose.runtime.Composable

abstract class ChapterCompose{
    @Composable
    abstract fun ContentView(name:String)
}