package com.example.belajarandroidjetpackpro.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.vo.Resource

interface MovieDataSource {
    fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTv(): LiveData<Resource<PagedList<TvEntity>>>

    fun getDetailMovie(movieId: String): LiveData<MovieEntity>

    fun getDetailTv(tvId: String): LiveData<TvEntity>

    fun setFavoriteMovie(movie: MovieEntity)

    fun setFavoriteTv(tv: TvEntity)

    fun getFavoriteMovie() : LiveData<PagedList<MovieEntity>>

    fun getFavoriteTv() : LiveData<PagedList<TvEntity>>

}