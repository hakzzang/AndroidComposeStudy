package com.hbs.composestudy.data.repository

import com.hbs.composestudy.R
import com.hbs.composestudy.model.Chapter
import com.hbs.composestudy.ui.chapter.ChapterType

interface ModifierRepository {
    fun makeChapterList() : List<Chapter>
}
class ModifierRepositoryImpl : ModifierRepository {
    override fun makeChapterList() = listOf(
        Chapter(ChapterType.Modifier, "Modifier", R.drawable.ic_modifier),
        Chapter(ChapterType.One, "Chapter1", R.drawable.ic_title),
        Chapter(ChapterType.Two, "Chapter2", R.drawable.ic_title),
        Chapter(ChapterType.Three, "Chapter3", R.drawable.ic_row)
    )
}
