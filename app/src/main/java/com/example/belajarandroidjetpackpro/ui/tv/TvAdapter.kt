package com.example.belajarandroidjetpackpro.ui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.databinding.ItemsTvBinding
import com.example.belajarandroidjetpackpro.ui.detail.DetailTvActivity

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {
    private var listTv = ArrayList<TvEntity>()

    fun setTv(listMovie: List<TvEntity>?) {
        if (listMovie == null) return
        this.listTv.clear()
        this.listTv.addAll(listMovie)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemsTvBinding =
            ItemsTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemsTvBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val course = listTv[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int {
        return listTv.size
    }

    inner class TvViewHolder(private val binding: ItemsTvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TvEntity) {
            with(binding) {
                tvItemTitleTv.text = tv.title
                tvItemDateReleaseTv.text = tv.dateRelease

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvActivity::class.java)
                    intent.putExtra(DetailTvActivity.EXTRA_DETAIL, tv.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tv.pathImage)
                    .centerCrop()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPosterTv)

            }
        }
    }


}