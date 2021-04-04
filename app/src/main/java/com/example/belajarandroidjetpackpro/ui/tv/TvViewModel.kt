package com.example.belajarandroidjetpackpro.ui.tv

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy

class TvViewModel : ViewModel() {
    fun getTv() : List<TvEntity> = DataDummy.generateDummyTv()
}