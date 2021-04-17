package com.example.belajarandroidjetpackpro.data.source.local

import androidx.lifecycle.LiveData
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.data.source.local.room.MovieDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null
        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao).apply { INSTANCE = this }
    }

    //MOVIE
    fun getAllMovie(): LiveData<List<MovieEntity>> = mMovieDao.getMovies()

    fun insertMovies(list: List<MovieEntity>) = mMovieDao.insertMovies(list)

    fun getDetailMovie(id: String): LiveData<MovieEntity> = mMovieDao.getDetailMovieById(id)

    fun setFavoriteMovie(movie: MovieEntity) {
        CoroutineScope(IO).launch {
            movie.favorite = !movie.favorite
            mMovieDao.updateMovie(movie)
        }
    }

    //TV
    fun getAllTv(): LiveData<List<TvEntity>> = mMovieDao.getTv()

    fun insertTV(list: List<TvEntity>) = mMovieDao.insertTv(list)

    fun getDetailTv(id: String): LiveData<TvEntity> = mMovieDao.getDetailTvById(id)

    fun setFavoriteTvShow(tv: TvEntity) {
        CoroutineScope(IO).launch {
            tv.favorite = !tv.favorite
            mMovieDao.updateTv(tv)
        }
    }
}