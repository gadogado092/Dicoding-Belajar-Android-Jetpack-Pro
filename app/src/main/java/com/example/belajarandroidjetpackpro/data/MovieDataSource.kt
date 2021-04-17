package com.example.belajarandroidjetpackpro.data

import androidx.lifecycle.LiveData
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.vo.Resource

interface MovieDataSource {
    fun getAllMovie(): LiveData<Resource<List<MovieEntity>>>

    fun getAllTv(): LiveData<Resource<List<TvEntity>>>

    fun getDetailMovie(movieId: String): LiveData<MovieEntity>

    fun getDetailTv(tvId: String): LiveData<TvEntity>

    fun setFavoriteMovie(movie: MovieEntity)

    fun setFavoriteTv(tv: TvEntity)

    fun getFavoriteMovie() : LiveData<List<MovieEntity>>

    fun getFavoriteTv() : LiveData<List<TvEntity>>

}