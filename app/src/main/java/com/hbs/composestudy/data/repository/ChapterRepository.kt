package com.hbs.composestudy.data.repository

import com.hbs.composestudy.R
import com.hbs.composestudy.model.Food

interface ChapterRepository {
    fun makeFoodItems(): List<Food>
}

class ChapterRepositoryImpl : ChapterRepository {
    override fun makeFoodItems(): List<Food> {
        return listOf(
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            ),
            Food(
                R.drawable.french_fries,
                "감자튀김",
                "감자튀김은 맛있어."
            )
        )
    }
}