package com.example.belajarandroidjetpackpro.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.belajarandroidjetpackpro.data.source.local.LocalDataSource
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.utils.AppExecutors
import com.example.belajarandroidjetpackpro.utils.DataDummy
import com.example.belajarandroidjetpackpro.utils.LiveDataTestUtil
import com.example.belajarandroidjetpackpro.utils.PagedListUtil
import com.example.belajarandroidjetpackpro.vo.Resource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val listMovieResponses = DataDummy.generateDummyRemoteListMovie()
    private val listTvResponse = DataDummy.generateDummyRemoteListTv()

    private val movie = DataDummy.generateDummyMovie()[0]
    private val tv = DataDummy.generateDummyTv()[0]

    @Test
    fun getAllMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovie()

        val movieEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovie()
        assertNotNull(movieEntity)
        assertEquals(listMovieResponses.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllTv() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getAllTv()).thenReturn(dataSourceFactory)
        movieRepository.getAllTv()

        val tvEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTv()))
        verify(local).getAllTv()
        assertNotNull(tvEntity)
        assertEquals(listTvResponse.size.toLong(), tvEntity.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movie
        `when`(local.getDetailMovie(movie.id)).thenReturn(dummyMovie)

        val data = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movie.id))
        verify(local).getDetailMovie(movie.id)
        assertNotNull(data)
        assertEquals(movie.id, data.id)
    }

    @Test
    fun getDetailTv() {
        val dummyTv = MutableLiveData<TvEntity>()
        dummyTv.value = tv
        `when`(local.getDetailTv(tv.id)).thenReturn(dummyTv)

        val data = LiveDataTestUtil.getValue(movieRepository.getDetailTv(tv.id))
        verify(local).getDetailTv(tv.id)
        assertNotNull(data)
        assertEquals(tv.id, data.id)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteMovie()

        val movieEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntity)
        assertEquals(listMovieResponses.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTv() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getFavoriteTv()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTv()

        val tvEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTv()))
        verify(local).getFavoriteTv()
        assertNotNull(tvEntity)
        assertEquals(listTvResponse.size.toLong(), tvEntity.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        val dataDummy = DataDummy.generateDummyMovie()[0].copy(favorite = true)
        doNothing().`when`(local).setFavoriteMovie(dataDummy)
        movieRepository.setFavoriteMovie(dataDummy)

        verify(local, times(1)).setFavoriteMovie(dataDummy)
    }

    @Test
    fun setFavoriteTv() {
        val dataDummy = DataDummy.generateDummyTv()[0].copy(favorite = true)
        doNothing().`when`(local).setFavoriteTvShow(dataDummy)
        movieRepository.setFavoriteTv(dataDummy)

        verify(local, times(1)).setFavoriteTvShow(dataDummy)
    }
}