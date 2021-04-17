package com.example.belajarandroidjetpackpro.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.vo.Resource

class TvViewModel(private val repository: MovieRepository) : ViewModel() {
    fun getTv(): LiveData<Resource<PagedList<TvEntity>>> = repository.getAllTv()
}