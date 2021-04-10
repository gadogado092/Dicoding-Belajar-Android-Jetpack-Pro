package com.example.belajarandroidjetpackpro.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.data.source.remote.response.MovieResponse
import com.example.belajarandroidjetpackpro.data.source.remote.response.TvResponse

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) : MovieDataSource {
    override fun getAllMovie(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                val movies= ArrayList<MovieEntity>()
                for (index in movieResponses.indices){
                    val response = movieResponses[index]
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.dateRelease,
                        response.pathImage,
                        response.description
                    )
                    movies.add(movie)
                }
                movieResult.postValue(movies)
            }
        })
        return movieResult
    }

    override fun getAllTv(): LiveData<List<TvEntity>> {
        val movieResult = MutableLiveData<List<TvEntity>>()
        remoteDataSource.getAllTv(object : RemoteDataSource.LoadTvCallback{
            override fun onAllTvReceived(tvResponses: List<TvResponse>) {
                val tv= ArrayList<TvEntity>()
                for (index in tvResponses.indices){
                    val response = tvResponses[index]
                    val movie = TvEntity(
                        response.id,
                        response.title,
                        response.dateRelease,
                        response.pathImage,
                        response.description
                    )
                    tv.add(movie)
                }
                movieResult.postValue(tv)
            }
        })
        return movieResult
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