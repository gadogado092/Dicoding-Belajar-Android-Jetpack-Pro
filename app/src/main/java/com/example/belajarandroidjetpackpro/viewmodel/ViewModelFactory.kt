package com.example.belajarandroidjetpackpro.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.belajarandroidjetpackpro.data.MovieRepository
import com.example.belajarandroidjetpackpro.di.Injection
import com.example.belajarandroidjetpackpro.ui.detail.DetailMovieViewModel
import com.example.belajarandroidjetpackpro.ui.detail.DetailTvViewModel
import com.example.belajarandroidjetpackpro.ui.favorite.movie.MovieFavoriteViewModel
import com.example.belajarandroidjetpackpro.ui.favorite.tv.TvFavoriteViewModel
import com.example.belajarandroidjetpackpro.ui.movie.MovieViewModel
import com.example.belajarandroidjetpackpro.ui.tv.TvViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                return TvViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvViewModel::class.java) -> {
                return DetailTvViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvFavoriteViewModel::class.java) -> {
                return TvFavoriteViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(MovieFavoriteViewModel::class.java) -> {
                return MovieFavoriteViewModel(mMovieRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}