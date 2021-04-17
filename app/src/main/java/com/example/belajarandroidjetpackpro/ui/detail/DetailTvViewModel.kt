package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.data.MovieRepository

class DetailTvViewModel(private val repository: MovieRepository) : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getDetail(): LiveData<TvEntity> {
        return repository.getDetailTv(id)
    }

    fun setFavoriteTv(tv: TvEntity){
        repository.setFavoriteTv(tv)
    }
}