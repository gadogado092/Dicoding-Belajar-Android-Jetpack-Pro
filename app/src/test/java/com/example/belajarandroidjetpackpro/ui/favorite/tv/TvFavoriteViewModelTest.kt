package com.example.belajarandroidjetpackpro.ui.favorite.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.data.source.local.entity.TvEntity
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
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class TvFavoriteViewModelTest {

    private lateinit var tvFavoriteViewModel: TvFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvEntity>>

    @Before
    fun before() {
        tvFavoriteViewModel = TvFavoriteViewModel(movieRepository)
    }

    @Test
    fun testGetTv() {
        val dummyTv = PagedTestDataSources.snapshot(DataDummy.generateDummyTv())
        val tv = MutableLiveData<PagedList<TvEntity>>()
        tv.value = dummyTv

        `when`(movieRepository.getFavoriteTv()).thenReturn(tv)
        val tvEntities = tvFavoriteViewModel.getTv().value
        verify(movieRepository).getFavoriteTv()

        Assert.assertNotNull(tvEntities)
        Assert.assertEquals(11, tvEntities?.size)
        Assert.assertEquals("The Arrow", tvEntities?.get(0)?.title)

        tvFavoriteViewModel.getTv().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTv)
    }

    class PagedTestDataSources private constructor(private val items: List<TvEntity>) : PositionalDataSource<TvEntity>() {
        companion object {
            fun snapshot(items: List<TvEntity> = listOf()): PagedList<TvEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<TvEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TvEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}