package com.example.belajarandroidjetpackpro.ui.movie

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy

class MovieViewModel: ViewModel() {
    fun getMovie() : List<MovieEntity> = DataDummy.generateDummyMovie()
}