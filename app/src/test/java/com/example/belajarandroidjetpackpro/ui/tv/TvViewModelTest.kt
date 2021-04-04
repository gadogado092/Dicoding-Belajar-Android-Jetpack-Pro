package com.example.belajarandroidjetpackpro.ui.tv

import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class TvViewModelTest  {

    private lateinit var tvViewModel: TvViewModel
    private var tv: List<TvEntity> = DataDummy.generateDummyTv()

    @Before
    fun before() {
        tvViewModel = mock(TvViewModel::class.java)
    }

    @Test
    fun testGetTv() {
        Mockito.`when`(tvViewModel.getTv()).thenReturn(tv)
        val dataMovie = tvViewModel.getTv()
        Assert.assertEquals(dataMovie.size, tv.size)
        Assert.assertEquals("The Arrow", tv[0].title)
    }
}