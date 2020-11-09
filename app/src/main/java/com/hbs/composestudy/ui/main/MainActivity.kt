package com.hbs.composestudy.ui.main

import android.content.Intent
import android.view.View
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.ui.tooling.preview.Preview
import com.hbs.composestudy.core.BaseActivity
import com.hbs.composestudy.model.Chapter
import com.hbs.composestudy.theme.ComposeStudyTheme
import com.hbs.composestudy.transition.TransitionIntentType
import com.hbs.composestudy.transition.TransitionType
import com.hbs.composestudy.ui.chapter.ChapterActivity

class MainActivity : BaseActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun bindTransitionType(): TransitionType = TransitionType.ARC

    @Composable
    override fun bindingCompose() {
        ComposeStudyTheme {
            MainCompose(viewModel) { view, chapter ->
                processActivity(view, chapter)
            }.run {
                ContentView()
            }
        }
    }

    private fun processActivity(view: View, chapter: Chapter) {
        val chapterIntent = Intent(this, ChapterActivity::class.java).apply {
            this.putExtra("Chapter", chapter)
            this.putExtra("TransitionName", TransitionIntentType.CHAPTER_ACTIVITY)
        }
        startActivityWithTransition(view, chapterIntent, TransitionIntentType.CHAPTER_ACTIVITY)
    }

    fun interface Callback {
        fun add(view: View, chapter: Chapter)
    }
}