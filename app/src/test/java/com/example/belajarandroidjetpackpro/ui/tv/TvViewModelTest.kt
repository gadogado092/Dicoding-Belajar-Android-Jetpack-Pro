package com.example.belajarandroidjetpackpro.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest  {

    private lateinit var tvViewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<TvEntity>>

    @Before
    fun before() {
        tvViewModel = TvViewModel(movieRepository)
    }

    @Test
    fun testGetTv() {
        val dummyTv = DataDummy.generateDummyTv()
        val tv = MutableLiveData<List<TvEntity>>()
        tv.value = dummyTv

        `when`(movieRepository.getAllTv()).thenReturn(tv)
        val tvEntities = tvViewModel.getTv().value
        verify(movieRepository).getAllTv()

        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(11, tvEntities?.size)
        Assert.assertEquals("The Arrow", tvEntities?.get(0)?.title)

        tvViewModel.getTv().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTv)
    }
}