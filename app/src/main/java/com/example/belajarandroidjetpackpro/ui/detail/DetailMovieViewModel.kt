package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getDetail(): MovieEntity? {
        var detail: MovieEntity? = null
        for (movieEntity in DataDummy.generateDummyMovie()) {
            if (movieEntity.id == id) {
                detail = movieEntity
            }
        }
        return detail
    }
}