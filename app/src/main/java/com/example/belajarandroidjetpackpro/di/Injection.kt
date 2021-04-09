package com.example.belajarandroidjetpackpro.di

import android.content.Context
import com.example.belajarandroidjetpackpro.data.source.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieRepository.getInstance(remoteDataSource)
    }
}