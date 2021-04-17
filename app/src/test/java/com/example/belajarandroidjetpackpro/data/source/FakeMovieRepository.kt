package com.example.belajarandroidjetpackpro.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.belajarandroidjetpackpro.data.MovieDataSource
import com.example.belajarandroidjetpackpro.data.NetworkBoundResource
import com.example.belajarandroidjetpackpro.data.source.local.LocalDataSource
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.data.source.remote.ApiResponse
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.data.source.remote.response.MovieResponse
import com.example.belajarandroidjetpackpro.data.source.remote.response.TvResponse
import com.example.belajarandroidjetpackpro.utils.AppExecutors
import com.example.belajarandroidjetpackpro.vo.Resource

class FakeMovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieDataSource {
    override fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
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

    override fun getAllTv(): LiveData<Resource<PagedList<TvEntity>>> {
        return object : NetworkBoundResource<PagedList<TvEntity>, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvEntity>?): Boolean {
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

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteTv(): LiveData<PagedList<TvEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTv(), config).build()
    }
}