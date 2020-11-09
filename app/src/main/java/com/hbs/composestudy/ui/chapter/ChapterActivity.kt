package com.hbs.composestudy.ui.chapter

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.hbs.composestudy.core.BaseActivity
import com.hbs.composestudy.model.Chapter
import com.hbs.composestudy.theme.ComposeStudyTheme
import com.hbs.composestudy.transition.TransitionType

class ChapterActivity : BaseActivity() {
    private val chapterFactory = ChapterFactoryImpl()

    override fun bindTransitionType(): TransitionType = TransitionType.ARC

    @Composable
    override fun bindingCompose() {
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