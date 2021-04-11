package com.example.belajarandroidjetpackpro.data.source.remote

import android.os.Handler
import android.os.Looper
import com.example.belajarandroidjetpackpro.data.source.remote.response.MovieResponse
import com.example.belajarandroidjetpackpro.data.source.remote.response.TvResponse
import com.example.belajarandroidjetpackpro.utils.EspressoIdlingResource
import com.example.belajarandroidjetpackpro.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovie(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onAllMoviesReceived(jsonHelper.loadMovie())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getAllTv(callback: LoadTvCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onAllTvReceived(jsonHelper.loadTv())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getDetailMovie(callback: LoadDetailMovieCallback, id: String) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onDetailMoviesReceived(jsonHelper.loadDetailMovie(id))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getDetailTv(callback: LoadDetailTvCallback, id: String) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onDetailTvReceived(jsonHelper.loadDetailTv(id))
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMoviesReceived(movieResponses: MovieResponse)
    }

    interface LoadDetailTvCallback {
        fun onDetailTvReceived(tvResponses: TvResponse)
    }

    interface LoadTvCallback {
        fun onAllTvReceived(tvResponses: List<TvResponse>)
    }
}