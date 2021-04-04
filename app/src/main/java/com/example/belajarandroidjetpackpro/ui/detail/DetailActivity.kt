package com.example.belajarandroidjetpackpro.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.databinding.ActivityDetailBinding
import com.example.belajarandroidjetpackpro.databinding.ContentDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    private lateinit var detailContentBinding: ContentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailCourseBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA_DETAIL)
            if (id != null) {
                viewModel.setSelected(id)
                populateDetail(viewModel.getDetail() as MovieEntity)
            }
        }
    }

    private fun populateDetail(detail: MovieEntity) {
        detailContentBinding.textTitle.text = detail.title
        detailContentBinding.textDescription.text = detail.description
        detailContentBinding.textDate.text = detail.dateRelease

        Glide.with(this)
            .load(detail.pathImage)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)
    }
}