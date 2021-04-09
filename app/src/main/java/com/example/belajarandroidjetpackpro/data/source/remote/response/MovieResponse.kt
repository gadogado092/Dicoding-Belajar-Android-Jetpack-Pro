package com.example.belajarandroidjetpackpro.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var id: String,
    var title: String,
    var dateRelease: String,
    var pathImage: String,
    var description: String,
) : Parcelable
