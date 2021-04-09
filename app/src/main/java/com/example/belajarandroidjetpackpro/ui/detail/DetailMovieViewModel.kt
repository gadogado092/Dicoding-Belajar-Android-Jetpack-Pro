package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.MovieRepository

class DetailMovieViewModel(private val repository: MovieRepository) : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getDetail(): MovieEntity? {
        return repository.getDetailMovie(id)
    }
}