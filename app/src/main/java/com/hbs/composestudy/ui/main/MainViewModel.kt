package com.hbs.composestudy.ui.main

import androidx.lifecycle.ViewModel
import com.hbs.composestudy.data.repository.ModifierRepositoryImpl

class MainViewModel : ViewModel(){
    private val modifierRepository = ModifierRepositoryImpl()

    fun getChapters() = modifierRepository.makeChapterList()
}