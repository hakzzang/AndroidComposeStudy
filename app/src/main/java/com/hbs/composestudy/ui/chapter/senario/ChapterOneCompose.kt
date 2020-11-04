package com.hbs.composestudy.ui.chapter.senario

import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class ChapterOneCompose(val name:String) : ChapterCompose() {
    @Composable
    private fun ColorTextStyle(color: Color): TextStyle {
        return TextStyle(color = color, fontSize = 16.sp)
    }

    @Composable
    override fun ContentView() {
        Text(text = "Hello1 $name!", style = ColorTextStyle(Color.Black))
    }
}