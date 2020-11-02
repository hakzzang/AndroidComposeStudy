package com.hbs.composestudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import com.hbs.composestudy.theme.ComposeStudyTheme
import com.hbs.composestudy.ui.ChapterFactoryImpl
import com.hbs.composestudy.ui.ChapterType

class MainActivity : AppCompatActivity() {
    private val chapterFactory = ChapterFactoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val chapterCompose= chapterFactory.makeChapter(ChapterType.Two)
                    chapterCompose.ContentView(name = "감자튀김")
                }
            }
        }
    }
}