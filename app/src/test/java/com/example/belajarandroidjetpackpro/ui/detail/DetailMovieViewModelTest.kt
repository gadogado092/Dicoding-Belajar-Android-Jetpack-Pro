package com.example.belajarandroidjetpackpro.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.data.MovieRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest  {
    private lateinit var detailMovieViewModel: DetailMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun before() {
        detailMovieViewModel = DetailMovieViewModel(movieRepository)
    }

    @Mock
    private lateinit var observer: Observer<MovieEntity?>

    @Test
    fun testGetDetail() {
        val dummy = MovieEntity(
            "4",
            "Aquaman",
            "21/12/2018",
            "R.drawable.poster_aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
        )
        val movie = MutableLiveData<MovieEntity>()
        movie.value= dummy

        Mockito.`when`(movieRepository.getDetailMovie("4")).thenReturn(movie)
        detailMovieViewModel.setSelected("4")
        val movieEntities = detailMovieViewModel.getDetail().value
        Mockito.verify(movieRepository).getDetailMovie("4")
        assertNotNull(movieEntities)
        assertEquals("Aquaman", movieEntities?.title)

        detailMovieViewModel.getDetail().observeForever(observer)
        Mockito.verify(observer).onChanged(dummy)
    }
}
