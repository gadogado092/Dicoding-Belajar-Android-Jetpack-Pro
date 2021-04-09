package com.example.belajarandroidjetpackpro.data.source

import androidx.lifecycle.LiveData
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.TvEntity

interface MovieDataSource {
    fun getAllMovie(): LiveData<List<MovieEntity>>

    fun getAllTv(): LiveData<List<TvEntity>>

    fun getDetailMovie(movieId: String): LiveData<MovieEntity?>

    fun getDetailTv(tvId: String): LiveData<TvEntity?>
}