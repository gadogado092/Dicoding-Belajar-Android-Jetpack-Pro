package com.example.belajarandroidjetpackpro.ui.tv

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.data.source.MovieRepository

class TvViewModel(private val repository: MovieRepository) : ViewModel() {
    fun getTv() : List<TvEntity> = repository.getAllTv()
}