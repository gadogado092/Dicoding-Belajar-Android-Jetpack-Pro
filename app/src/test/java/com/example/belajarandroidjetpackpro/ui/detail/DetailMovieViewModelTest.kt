package com.example.belajarandroidjetpackpro.ui.detail

import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.data.MovieEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class DetailMovieViewModelTest  {
    private lateinit var detatilMovieViewModel: DetailMovieViewModel
    private var movie = MovieEntity(
        "4",
        "Aquaman",
        "21/12/2018",
        R.drawable.poster_aquaman,
        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
    )

    @Before
    fun before() {
        detatilMovieViewModel = Mockito.mock(DetailMovieViewModel::class.java)
    }

    @Test
    fun testGetDetail() {
        Mockito.`when`(detatilMovieViewModel.getDetail()).thenReturn(movie)
        val data = detatilMovieViewModel.getDetail()
        Assert.assertEquals("Aquaman", data?.title)
    }
}