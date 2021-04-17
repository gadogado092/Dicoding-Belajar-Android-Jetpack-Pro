package com.example.belajarandroidjetpackpro.di

import android.content.Context
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.local.LocalDataSource
import com.example.belajarandroidjetpackpro.data.source.local.room.MovieDatabase
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.utils.AppExecutors
import com.example.belajarandroidjetpackpro.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}