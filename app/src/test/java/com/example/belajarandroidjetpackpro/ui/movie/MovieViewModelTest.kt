package com.example.belajarandroidjetpackpro.ui.movie

import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.mockito.Mockito.*

class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel
    private var movies: List<MovieEntity> = DataDummy.generateDummyMovie()

    @Before
    fun before() {
        movieViewModel = mock(MovieViewModel::class.java)
    }

    @Test
    fun testGetMovie() {
        `when`(movieViewModel.getMovie()).thenReturn(movies)
        val dataMovie = movieViewModel.getMovie()
        assertEquals(dataMovie.size, movies.size)
        assertEquals("1", movies[0].id)
    }
}