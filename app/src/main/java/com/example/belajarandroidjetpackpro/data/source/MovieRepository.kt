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
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                var detail: MovieEntity? = null
                for (response in movieResponses) {
                    if (response.id == movieId) {
                        detail = MovieEntity(
                            response.id,
                            response.title,
                            response.dateRelease,
                            response.pathImage,
                            response.description
                        )
                    }
                }
                detailResults.postValue(detail)
            }

        })

        return detailResults
    }

    override fun getDetailTv(tvId: String): LiveData<TvEntity?> {
        val detailResult = MutableLiveData<TvEntity>()

        remoteDataSource.getAllTv(object : RemoteDataSource.LoadTvCallback {
            override fun onAllTvReceived(tvResponses: List<TvResponse>) {
                var detail: TvEntity? = null
                for (response in tvResponses) {
                    if (response.id == tvId) {
                        detail = TvEntity(
                            response.id,
                            response.title,
                            response.dateRelease,
                            response.pathImage,
                            response.description
                        )
                    }
                }
                detailResult.postValue(detail)
            }
        })

        return detailResult
    }
}