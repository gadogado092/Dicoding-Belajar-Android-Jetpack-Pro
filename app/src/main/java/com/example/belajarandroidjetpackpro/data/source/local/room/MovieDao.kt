package com.example.belajarandroidjetpackpro.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(courses: List<MovieEntity>)

    @Query("SELECT * FROM tventities")
    fun getTv(): DataSource.Factory<Int, TvEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(courses: List<TvEntity>)

    @Query("SELECT * FROM movieentities WHERE id = :id")
    fun getDetailMovieById(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tventities WHERE id = :id")
    fun getDetailTvById(id: String): LiveData<TvEntity>

    @Update(entity = MovieEntity::class)
    fun updateMovie(movie: MovieEntity)

    @Update(entity = TvEntity::class)
    fun updateTv(tv: TvEntity)

    @Query("SELECT * FROM movieentities WHERE favorite = 1")
    fun getListFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tventities WHERE favorite = 1")
    fun getListFavoriteTv(): DataSource.Factory<Int, TvEntity>

}