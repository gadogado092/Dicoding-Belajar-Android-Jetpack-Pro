package com.example.belajarandroidjetpackpro.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.belajarandroidjetpackpro.data.source.local.LocalDataSource
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.data.source.remote.ApiResponse
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.data.source.remote.response.MovieResponse
import com.example.belajarandroidjetpackpro.data.source.remote.response.TvResponse
import com.example.belajarandroidjetpackpro.utils.AppExecutors
import com.example.belajarandroidjetpackpro.vo.Resource

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieDataSource {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovie(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<MovieEntity>> {
                return localDataSource.getAllMovie()
            }

            override fun shouldFetch(data: List<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getAllMovie()
            }

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.dateRelease,
                        response.pathImage,
                        response.description
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }

        }.asLiveData()

    }

    override fun getAllTv(): LiveData<Resource<List<TvEntity>>> {
        return object : NetworkBoundResource<List<TvEntity>, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TvEntity>> {
                return localDataSource.getAllTv()
            }

            override fun shouldFetch(data: List<TvEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> {
                return remoteDataSource.getAllTv()
            }

            override fun saveCallResult(data: List<TvResponse>) {
                val tvList = ArrayList<TvEntity>()
                for (response in data) {
                    val tv = TvEntity(
                        response.id,
                        response.title,
                        response.dateRelease,
                        response.pathImage,
                        response.description
                    )
                    tvList.add(tv)
                }
                localDataSource.insertTV(tvList)
            }

        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieEntity> {
        return localDataSource.getDetailMovie(movieId)
    }

    override fun getDetailTv(tvId: String): LiveData<TvEntity> {
        return localDataSource.getDetailTv(tvId)
    }

    override fun setFavoriteMovie(movie: MovieEntity) {
        return localDataSource.setFavoriteMovie(movie)
    }

    override fun setFavoriteTv(tv: TvEntity) {
        return localDataSource.setFavoriteTvShow(tv)
    }
}