package com.example.belajarandroidjetpackpro.ui.detail

import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.data.TvEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class DetailTvViewModelTest {
    private lateinit var detailTvViewModel: DetailTvViewModel
    private var tv = TvEntity(
        "2",
        "Doom Patrol",
        "15/02/2019",
        R.drawable.poster_doom_patrol,
        "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
    )

    @Before
    fun before() {
        detailTvViewModel = mock(DetailTvViewModel::class.java)
    }

    @Test
    fun testGetDetail() {
        Mockito.`when`(detailTvViewModel.getDetail()).thenReturn(tv)
        val data = detailTvViewModel.getDetail()
        Assert.assertEquals("Doom Patrol", data?.title)
    }
}