package com.example.belajarandroidjetpackpro.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.data.source.local.entity.MovieEntity
import com.example.belajarandroidjetpackpro.databinding.ItemsMovieBinding
import com.example.belajarandroidjetpackpro.ui.detail.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<MovieEntity>()

    fun setMovie(listMovie: List<MovieEntity>?) {
        if (listMovie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(listMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val course = listMovie[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    inner class MovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitleMovie.text = movie.title
                tvItemDateReleaseMovie.text = movie.dateRelease

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_DETAIL, movie.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(
                        itemView.context.resources.getIdentifier(
                            movie.pathImage,
                            "drawable",
                            itemView.context.packageName
                        )
                    )
                    .centerCrop()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPosterMovie)

            }
        }
    }


}