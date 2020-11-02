package com.hbs.composestudy.ui

import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.hbs.composestudy.theme.ComposeStudyTheme

class ChapterOneCompose : ChapterCompose() {
    @Composable
    fun ColorTextStyle(color: Color): TextStyle {
        return TextStyle(color = color, fontSize = 16.sp)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeStudyTheme {
            ContentView("감자튀김!")
        }
    }

    @Composable
    override fun ContentView(name : String) {
        Text(text = "Hello1 $name!", style = ColorTextStyle(Color.Black))
        Text(text = "Hello2 $name!", style = ColorTextStyle(Color.Yellow))
        Text(text = "Hello3 $name!", style = ColorTextStyle(Color.Red))
        Text(text = "Hello4 $name!", style = ColorTextStyle(Color.Gray))
    }
}