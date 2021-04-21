package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity

class DetailTvViewModel(private val repository: MovieRepository) : ViewModel() {
    val id = MutableLiveData<String>()

    fun setSelected(id: String) {
        this.id.value = id
    }

    var tv: LiveData<TvEntity> = Transformations.switchMap(id) { id ->
        repository.getDetailTv(id)
    }

    fun setFavoriteTv() {
        val tv = tv.value
        if (tv != null) {
            repository.setFavoriteTv(tv)
        }
    }
}