package com.example.belajarandroidjetpackpro.ui.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity

class TvFavoriteViewModel(private val repository: MovieRepository) : ViewModel() {
    fun getTv(): LiveData<PagedList<TvEntity>> = repository.getFavoriteTv()
}