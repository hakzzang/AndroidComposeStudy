package com.hbs.composestudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.hbs.composestudy.ui.ComposeStudyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello1 $name!", style = ColorTextStyle(Color.Black))
    Text(text = "Hello2 $name!", style = ColorTextStyle(Color.Yellow))
    Text(text = "Hello3 $name!", style = ColorTextStyle(Color.Red))
    Text(text = "Hello4 $name!", style = ColorTextStyle(Color.Gray))
}

@Composable
fun ColorTextStyle(color: Color): TextStyle {
    return TextStyle(color = color, fontSize = 16.sp)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        Greeting("감자튀김!")
    }
}