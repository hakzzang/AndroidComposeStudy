package com.hbs.composestudy.ui.chapter.senario

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class ChapterTwoCompose constructor(private val name: String) : ChapterCompose() {
    @Composable
    fun ColorTextStyle(color: Color): TextStyle {
        return TextStyle(color = color, fontSize = 16.sp)
    }

    @Composable
    override fun ContentView() {
        Column {
            Text(text = "Hello1 $name!", style = ColorTextStyle(Color.Black))
            Text(text = "Hello2 $name!", style = ColorTextStyle(Color.Yellow))
            Text(text = "Hello3 $name!", style = ColorTextStyle(Color.Red))
            Text(text = "Hello4 $name!", style = ColorTextStyle(Color.Gray))
        }
    }
}