package com.hbs.composestudy.ui.chapter.modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.hbs.composestudy.data.repository.ModifierRepositoryImpl
import com.hbs.composestudy.model.Chapter
import com.hbs.composestudy.theme.typography
import com.hbs.composestudy.ui.chapter.senario.ChapterCompose

class ModifierCompose : ChapterCompose(){
    private val modifierRepository = ModifierRepositoryImpl()

    @Composable
    override fun ContentView() {
        TableLayout(modifierRepository.makeChapterList(), 2)
    }

    @Composable
    fun TableLayout(chapters: List<Chapter>, rowSize: Int) {
        val windowedChapters = chapters.windowed(rowSize, rowSize)
        LazyColumnFor(
            modifier = Modifier.fillMaxSize(),
            items = windowedChapters,
            itemContent = { chapters ->
                Row(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
                    chapters.forEachIndexed { index, chapter ->
                        ChapterCard(Modifier.weight(10f), chapter)
                        if(chapters.size == 2 && index % 2 == 0){
                            Spacer(Modifier.weight(1f))
                        }
                    }
                }
            }
        )
    }

    @Composable
    fun ChapterCard(modifier: Modifier, chapter: Chapter){
        Card(
            modifier.clickable(onClick = {

            }), elevation = 4.dp
        ){
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Spacer(modifier = Modifier.fillMaxWidth().height(36.dp))
                Image(vectorResource(id = chapter.imageResource), modifier = Modifier.size(120.dp))
                Spacer(modifier = Modifier.fillMaxWidth().height(18.dp))
                Text(chapter.title, style = typography.h5)
                Spacer(modifier = Modifier.fillMaxWidth().height(36.dp))
            }
        }
    }
}