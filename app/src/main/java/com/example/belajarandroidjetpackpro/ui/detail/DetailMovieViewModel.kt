package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val repository: MovieRepository) : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getDetail(): LiveData<MovieEntity> {
        return repository.getDetailMovie(id)
    }

    fun setFavoriteMovie(movie: MovieEntity){
        repository.setFavoriteMovie(movie)
    }
}