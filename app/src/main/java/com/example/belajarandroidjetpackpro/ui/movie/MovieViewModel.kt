package com.example.belajarandroidjetpackpro.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.vo.Resource

class MovieViewModel (private val repository: MovieRepository): ViewModel() {
    fun getMovie() : LiveData<Resource<List<MovieEntity>>> = repository.getAllMovie()
}