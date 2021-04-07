package com.example.belajarandroidjetpackpro.ui.movie

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun before() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun testGetMovie() {
        val dataMovie = movieViewModel.getMovie()
        assertNotNull(dataMovie)
        assertEquals(11, dataMovie.size)
        assertEquals("5", dataMovie[4].id)
    }
}