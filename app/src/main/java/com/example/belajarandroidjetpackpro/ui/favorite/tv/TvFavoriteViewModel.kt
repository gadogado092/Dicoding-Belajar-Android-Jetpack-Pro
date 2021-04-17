package com.example.belajarandroidjetpackpro.ui.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.vo.Resource

class TvFavoriteViewModel(private val repository: MovieRepository) : ViewModel() {
    fun getTv(): LiveData<List<TvEntity>> = repository.getFavoriteTv()
}