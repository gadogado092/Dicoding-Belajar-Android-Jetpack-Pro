package com.example.belajarandroidjetpackpro.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.databinding.ActivityDetailTvBinding
import com.example.belajarandroidjetpackpro.databinding.ContentDetailTvBinding
import com.example.belajarandroidjetpackpro.viewmodel.ViewModelFactory

class DetailTvActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    private lateinit var detailContentBinding: ContentDetailTvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailBinding = ActivityDetailTvBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContentTv

        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        activityDetailBinding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailTvViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(DetailMovieActivity.EXTRA_DETAIL)
            if (id != null) {
                viewModel.setSelected(id)
                populateDetail(viewModel.getDetail() as TvEntity)
            }
        }
    }

    private fun populateDetail(detail: TvEntity) {
        detailContentBinding.textTitleTv.text = detail.title
        detailContentBinding.textDescriptionTv.text = detail.description
        detailContentBinding.textDateTv.text = detail.dateRelease

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
            .into(detailContentBinding.imagePosterTv)
    }
}