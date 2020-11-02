package com.hbs.composestudy.ui

sealed class ChapterType {
    object One : ChapterType()
}

interface ChapterFactory {
    fun makeChapter(chapterType: ChapterType): ChapterCompose
}
class ChapterFactoryImpl : ChapterFactory{

    override fun makeChapter(chapterType: ChapterType): ChapterCompose {
        return when (chapterType) {
            ChapterType.One -> {
                ChapterComposeOne()
            }
        }
    }

}