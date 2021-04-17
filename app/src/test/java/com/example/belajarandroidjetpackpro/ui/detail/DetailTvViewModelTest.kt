package com.example.belajarandroidjetpackpro.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
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
class DetailTvViewModelTest {
    private lateinit var detailTvViewModel: DetailTvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun before() {
        detailTvViewModel = DetailTvViewModel(movieRepository)
    }

    @Mock
    private lateinit var observer: Observer<TvEntity?>

    @Test
    fun testGetDetail() {
        val dummy = TvEntity(
            "4",
            "Gotham",
            "22/09/2014",
            "R.drawable.poster_gotham",
            "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
        )
        val tv = MutableLiveData<TvEntity>()
        tv.value = dummy

        Mockito.`when`(movieRepository.getDetailTv("4")).thenReturn(tv)
        detailTvViewModel.setSelected("4")
        val tvEntities = detailTvViewModel.getDetail().value
        Mockito.verify(movieRepository).getDetailTv("4")
        assertNotNull(tvEntities)
        assertEquals("Gotham", tvEntities?.title)

        detailTvViewModel.getDetail().observeForever(observer)
        Mockito.verify(observer).onChanged(dummy)

    }
}