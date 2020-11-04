package com.hbs.composestudy.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.hbs.composestudy.ui.chapter.ChapterType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Chapter(val chapterType: ChapterType, val title:String, @DrawableRes val imageResource:Int) : Parcelable