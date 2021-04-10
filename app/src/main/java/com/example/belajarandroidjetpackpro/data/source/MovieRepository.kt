package com.example.belajarandroidjetpackpro.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.data.source.remote.response.MovieResponse
import com.example.belajarandroidjetpackpro.data.source.remote.response.TvResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovie(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.dateRelease,
                        response.pathImage,
                        response.description
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }

        })
        return movieResults
    }

    override fun getAllTv(): LiveData<List<TvEntity>> {
        val tvResults = MutableLiveData<List<TvEntity>>()
        remoteDataSource.getAllTv(object : RemoteDataSource.LoadTvCallback {
            override fun onAllTvReceived(tvResponses: List<TvResponse>) {
                val tvList = ArrayList<TvEntity>()
                for (response in tvResponses) {
                    val tv = TvEntity(
                        response.id,
                        response.title,
                        response.dateRelease,
                        response.pathImage,
                        response.description
                    )
                    tvList.add(tv)
                }
                tvResults.postValue(tvList)
            }
        })
        return tvResults
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieEntity?> {
        val detailResults = MutableLiveData<MovieEntity>()
        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMoviesReceived(movieResponses: MovieResponse) {
                val movie = MovieEntity(
                    movieResponses.id,
                    movieResponses.title,
                    movieResponses.dateRelease,
                    movieResponses.pathImage,
                    movieResponses.description
                )
                detailResults.postValue(movie)
            }
        }, movieId)
        return detailResults
    }

    override fun getDetailTv(tvId: String): LiveData<TvEntity?> {
        val detailResults = MutableLiveData<TvEntity>()
        remoteDataSource.getDetailTv(object : RemoteDataSource.LoadDetailTvCallback {
            override fun onDetailTvReceived(tvResponse: TvResponse) {
                val tv = TvEntity(
                    tvResponse.id,
                    tvResponse.title,
                    tvResponse.dateRelease,
                    tvResponse.pathImage,
                    tvResponse.description
                )
                detailResults.postValue(tv)
            }
        }, tvId)
        return detailResults
    }
}