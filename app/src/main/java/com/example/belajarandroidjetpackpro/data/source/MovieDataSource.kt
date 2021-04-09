package com.example.belajarandroidjetpackpro.data.source

import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.TvEntity

interface MovieDataSource {
    fun getAllMovie(): List<MovieEntity>

    fun getAllTv(): List<TvEntity>

    fun getDetailMovie(movieId: String): MovieEntity?

    fun getDetailTv(tvId: String): TvEntity?
}