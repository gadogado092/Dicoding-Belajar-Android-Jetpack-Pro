package com.example.belajarandroidjetpackpro.ui.detail

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest  {
    private lateinit var detailMovieViewModel: DetailMovieViewModel

    @Before
    fun before() {
        detailMovieViewModel = DetailMovieViewModel()
    }

    @Test
    fun testGetDetail() {
        detailMovieViewModel.setSelected("4")
        val data = detailMovieViewModel.getDetail()
        assertNotNull(data)
        assertEquals("Aquaman", data?.title)
    }
}