package com.example.belajarandroidjetpackpro.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun before() {
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun testMovie() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovies

        `when`(movieRepository.getAllMovie()).thenReturn(movies)
        val movieEntities = movieViewModel.getMovie().value
        verify(movieRepository).getAllMovie()
        assertNotNull(movieEntities)
        assertEquals(11, movieEntities?.size)
        assertEquals("5", movieEntities?.get(4)?.id)

        movieViewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovies)

    }
}