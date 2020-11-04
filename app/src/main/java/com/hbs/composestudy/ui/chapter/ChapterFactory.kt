package com.hbs.composestudy.ui.chapter

import android.os.Parcelable
import com.hbs.composestudy.ui.chapter.senario.ChapterCompose
import com.hbs.composestudy.ui.chapter.senario.ChapterOneCompose
import com.hbs.composestudy.ui.chapter.senario.ChapterThreeCompose
import com.hbs.composestudy.ui.chapter.senario.ChapterTwoCompose
import com.hbs.composestudy.ui.chapter.modifier.ModifierCompose
import kotlinx.android.parcel.Parcelize
import java.security.InvalidParameterException

sealed class ChapterType : Parcelable {
    @Parcelize
    object Modifier : ChapterType()

    @Parcelize
    object One : ChapterType()

    @Parcelize
    object Two : ChapterType()

    @Parcelize
    object Three : ChapterType()
}

interface ChapterFactory {
    fun makeChapter(chapterType: ChapterType): ChapterCompose
}

class ChapterFactoryImpl : ChapterFactory {
    override fun makeChapter(chapterType: ChapterType): ChapterCompose {
        return when (chapterType) {
            ChapterType.One -> {
                ChapterOneCompose("감자튀김")
            }
            ChapterType.Two -> {
                ChapterTwoCompose("감자튀김")
            }
            ChapterType.Three -> {
                ChapterThreeCompose()
            }
            ChapterType.Modifier -> {
                ModifierCompose()
            }
        }
    }

}