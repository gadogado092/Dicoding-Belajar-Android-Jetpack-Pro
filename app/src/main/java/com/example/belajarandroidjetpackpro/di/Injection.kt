package com.example.belajarandroidjetpackpro.di

import android.content.Context
import com.example.belajarandroidjetpackpro.data.AcademyRepository
import com.example.belajarandroidjetpackpro.data.source.local.LocalDataSource
import com.example.belajarandroidjetpackpro.data.source.local.room.AcademyDatabase
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.utils.AppExecutors
import com.example.belajarandroidjetpackpro.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}