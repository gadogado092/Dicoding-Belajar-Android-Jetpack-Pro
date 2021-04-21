package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val repository: MovieRepository) : ViewModel() {
    val id = MutableLiveData<String>()

    fun setSelected(id: String) {
        this.id.value = id
    }

    var movie: LiveData<MovieEntity> = Transformations.switchMap(id) { id ->
        repository.getDetailMovie(id)
    }

    fun setFavoriteMovie(){
        val movie = movie.value
        if (movie != null) {
            repository.setFavoriteMovie(movie)
        }
    }
}