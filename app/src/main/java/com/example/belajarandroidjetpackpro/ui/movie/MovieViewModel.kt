package com.example.belajarandroidjetpackpro.ui.movie

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.MovieRepository

class MovieViewModel (private val repository: MovieRepository): ViewModel() {
    fun getMovie() : List<MovieEntity> = repository.getAllMovie()
}