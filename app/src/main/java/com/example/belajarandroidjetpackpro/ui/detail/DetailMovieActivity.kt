package com.example.belajarandroidjetpackpro.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.databinding.ActivityDetailMovieBinding
import com.example.belajarandroidjetpackpro.databinding.ContentDetailMovieBinding
import com.example.belajarandroidjetpackpro.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    private lateinit var viewModel: DetailMovieViewModel
    private lateinit var detailContentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContentMovie

        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        activityDetailBinding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA_DETAIL)
            if (id != null) {
                activityDetailBinding.progressBar.visibility = View.VISIBLE
                viewModel.setSelected(id)
                viewModel.getDetail().observe(this, { detail ->
                    activityDetailBinding.progressBar.visibility = View.GONE
                    detail?.let { populateDetail(it) }
                })
            }
        }
    }

    private fun populateDetail(detail: MovieEntity) {
        detailContentBinding.textTitleMovie.text = detail.title
        detailContentBinding.textDescriptionMovie.text = detail.description
        detailContentBinding.textDateMovie.text = detail.dateRelease
        setFavoriteState(detail.favorite)

        Glide.with(this)
            .load(
                this.resources.getIdentifier(
                    detail.pathImage,
                    "drawable",
                    this.packageName
                )
            )
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePosterMovie)

        detailContentBinding.imageFavorite.setOnClickListener {
            if (detail.favorite){
                Snackbar.make(findViewById(android.R.id.content), "Terhapus Dari Favorite", Snackbar.LENGTH_SHORT).show()
            }else {
                Snackbar.make(findViewById(android.R.id.content), "Ditambahkan Ke Favorite", Snackbar.LENGTH_SHORT).show()
            }
            viewModel.setFavoriteMovie(detail)
        }
    }

    private fun setFavoriteState(status: Boolean){
        if (status) {
            detailContentBinding.imageFavorite.setImageResource(R.drawable.ic_favorite_true)
        } else {
            detailContentBinding.imageFavorite.setImageResource(R.drawable.ic_favorite_false)
        }
    }
}