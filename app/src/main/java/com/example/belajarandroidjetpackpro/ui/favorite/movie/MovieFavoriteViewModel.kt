package com.example.belajarandroidjetpackpro.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.MovieRepository

class MovieFavoriteViewModel (private val repository: MovieRepository): ViewModel() {
    fun getMovie() : LiveData<PagedList<MovieEntity>> = repository.getFavoriteMovie()
}