package com.example.belajarandroidjetpackpro.ui.detail

import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertEquals

class DetailTvViewModelTest  {
    private lateinit var detailTvViewModel: DetailTvViewModel

    @Before
    fun before() {
        detailTvViewModel = DetailTvViewModel()
    }

    @Test
    fun testGetDetail() {
        detailTvViewModel.setSelected("4")
        val data = detailTvViewModel.getDetail()
        assertNotNull(data)
        assertEquals("Gotham", data?.title)
    }
}