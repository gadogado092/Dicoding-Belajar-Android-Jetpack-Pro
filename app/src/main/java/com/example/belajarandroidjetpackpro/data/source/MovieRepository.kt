package com.example.belajarandroidjetpackpro.data.source

import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource

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

    override fun getAllMovie(): List<MovieEntity> {
        val movieResponses = remoteDataSource.getAllMovie()
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
        return movieList
    }

    override fun getAllTv(): List<TvEntity> {
        val tvResponses = remoteDataSource.getAllTv()
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
        return tvList
    }

    override fun getDetailMovie(movieId: String): MovieEntity? {
        val movieResponses = remoteDataSource.getAllMovie()
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
        return detail
    }

    override fun getDetailTv(tvId: String): TvEntity? {
        val tvResponses = remoteDataSource.getAllTv()
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
        return detail
    }
}