package com.example.belajarandroidjetpackpro.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.belajarandroidjetpackpro.data.source.remote.RemoteDataSource
import com.example.belajarandroidjetpackpro.utils.DataDummy
import com.example.belajarandroidjetpackpro.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val listMovieResponses = DataDummy.generateDummyRemoteListMovie()
    private val listTvResponse = DataDummy.generateDummyRemoteListTv()

    private val movieResponse = listMovieResponses[0]
    private val tvResponse = listTvResponse[0]

    @Test
    fun getAllMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(listMovieResponses)
            null
        }.`when`(remote).getAllMovie(any())
        val movieEntity = LiveDataTestUtil.getValue(movieRepository.getAllMovie())
        verify(remote).getAllMovie(any())
        assertNotNull(movieEntity)
        assertEquals(listMovieResponses.size.toLong(), movieEntity.size.toLong())
    }

    @Test
    fun getAllTv() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvCallback)
                .onAllTvReceived(listTvResponse)
            null
        }.`when`(remote).getAllTv(any())
        val tvEntity = LiveDataTestUtil.getValue(movieRepository.getAllTv())
        verify(remote).getAllTv(any())
        assertNotNull(tvEntity)
        assertEquals(listTvResponse.size.toLong(), tvEntity.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailMovieCallback)
                .onDetailMoviesReceived(movieResponse)
            null
        }.`when`(remote).getDetailMovie(any(), eq("1"))
        val movieEntity = LiveDataTestUtil.getValue(movieRepository.getDetailMovie("1"))
        verify(remote).getDetailMovie(any(),eq("1"))
        assertNotNull(movieEntity)
        assertEquals(movieResponse.title, movieEntity?.title)
    }

    @Test
    fun getDetailTv() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailTvCallback)
                .onDetailTvReceived(tvResponse)
            null
        }.`when`(remote).getDetailTv(any(), eq("1"))
        val tvEntity = LiveDataTestUtil.getValue(movieRepository.getDetailTv("1"))
        verify(remote).getDetailTv(any(),eq("1"))
        assertNotNull(tvEntity)
        assertEquals(tvResponse.title, tvEntity?.title)
    }
}