package com.example.belajarandroidjetpackpro.data.source.remote

import android.os.Handler
import android.os.Looper
import com.example.belajarandroidjetpackpro.data.source.remote.response.MovieResponse
import com.example.belajarandroidjetpackpro.data.source.remote.response.TvResponse
import com.example.belajarandroidjetpackpro.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 3000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovie(callback: LoadMoviesCallback){
        handler.postDelayed({ callback.onAllMoviesReceived(jsonHelper.loadMovie()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllTv(callback: LoadTvCallback){
        handler.postDelayed({ callback.onAllTvReceived(jsonHelper.loadTv()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }
    interface LoadTvCallback {
        fun onAllTvReceived(tvResponses: List<TvResponse>)
    }
}