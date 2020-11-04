package com.hbs.composestudy.ui.chapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import com.hbs.composestudy.model.Chapter
import com.hbs.composestudy.theme.ComposeStudyTheme

class ChapterActivity : AppCompatActivity() {
    private val chapterFactory = ChapterFactoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val chapter = intent.getParcelableExtra<Chapter>("Chapter")?: return@Surface
                    val chapterCompose= chapterFactory.makeChapter(chapter.chapterType)
                    chapterCompose.ContentView()
                }
            }
        }
    }
}