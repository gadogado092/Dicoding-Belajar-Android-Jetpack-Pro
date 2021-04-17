package com.example.belajarandroidjetpackpro.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tventities")
data class TvEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "dateRelease")
    var dateRelease: String,

    @ColumnInfo(name = "pathImage")
    var pathImage: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
)