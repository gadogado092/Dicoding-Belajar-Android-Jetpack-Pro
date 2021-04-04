package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy

class DetailTvViewModel : ViewModel() {
    private lateinit var id: String

    fun setSelected(id: String) {
        this.id = id
    }

    fun getDetail(): TvEntity? {
        var detail: TvEntity? = null
        for (tvEntity in DataDummy.generateDummyTv()) {
            if (tvEntity.id == id) {
                detail = tvEntity
            }
        }
        return detail
    }
}