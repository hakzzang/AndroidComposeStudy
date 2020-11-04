package com.hbs.composestudy.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.ViewModelProvider
import androidx.ui.tooling.preview.Preview
import com.hbs.composestudy.model.Chapter
import com.hbs.composestudy.theme.ComposeStudyTheme
import com.hbs.composestudy.ui.chapter.ChapterActivity

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                MainCompose(viewModel) { chapter ->
                    processActivity(chapter)
                }.run {
                    ContentView()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeStudyTheme {
            MainCompose(viewModel) { chapter ->
                processActivity(chapter)
            }.run {
                ContentView()
            }
        }
    }

    private fun processActivity(chapter: Chapter) {
        val chapterIntent = Intent(this, ChapterActivity::class.java).apply {
            this.putExtra("Chapter" , chapter)
        }
        startActivity(chapterIntent)
    }

    fun interface Callback {
        fun add(chapter: Chapter)
    }
}