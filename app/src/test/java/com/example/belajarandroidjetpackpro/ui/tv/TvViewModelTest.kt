package com.example.belajarandroidjetpackpro.ui.tv

import junit.framework.Assert.assertNotNull
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvViewModelTest  {

    private lateinit var tvViewModel: TvViewModel

    @Before
    fun before() {
        tvViewModel = TvViewModel()
    }

    @Test
    fun testGetTv() {
        val dataMovie = tvViewModel.getTv()
        assertNotNull(dataMovie)
        Assert.assertEquals(11, dataMovie.size)
        Assert.assertEquals("The Arrow", dataMovie[0].title)
    }
}