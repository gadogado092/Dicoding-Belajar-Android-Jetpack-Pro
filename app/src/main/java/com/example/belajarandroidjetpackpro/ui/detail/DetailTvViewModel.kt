package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.data.source.MovieRepository

class DetailTvViewModel(private val repository: MovieRepository) : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getDetail(): TvEntity? {
        return repository.getDetailTv(id)
    }
}