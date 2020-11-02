package com.hbs.composestudy.ui

sealed class ChapterType {
    object One : ChapterType()
    object Two : ChapterType()
}

interface ChapterFactory {
    fun makeChapter(chapterType: ChapterType): ChapterCompose
}

class ChapterFactoryImpl : ChapterFactory{

    override fun makeChapter(chapterType: ChapterType): ChapterCompose {
        return when (chapterType) {
            ChapterType.One -> {
                ChapterOneCompose()
            }
            ChapterType.Two -> {
                ChapterTwoCompose()
            }
        }
    }

}