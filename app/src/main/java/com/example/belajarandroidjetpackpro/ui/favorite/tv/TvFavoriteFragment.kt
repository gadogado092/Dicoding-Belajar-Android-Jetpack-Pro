package com.example.belajarandroidjetpackpro.ui.favorite.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarandroidjetpackpro.databinding.FragmentTvFavoriteBinding
import com.example.belajarandroidjetpackpro.viewmodel.ViewModelFactory

class TvFavoriteFragment : Fragment() {

    private lateinit var fragmentFavoriteTvBinding : FragmentTvFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteTvBinding =
            FragmentTvFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity !=null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvFavoriteViewModel::class.java]
            val tvAdapter = TvFavoriteAdapter()

            fragmentFavoriteTvBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTv().observe(viewLifecycleOwner,{ tv->
                fragmentFavoriteTvBinding.progressBar.visibility = View.GONE
                tvAdapter.submitList(tv)
                tvAdapter.notifyDataSetChanged()
                if (tv.isEmpty()){
                    fragmentFavoriteTvBinding.tvNoData.visibility = View.VISIBLE
                }else{
                    fragmentFavoriteTvBinding.tvNoData.visibility = View.GONE
                }
            })

            with(fragmentFavoriteTvBinding.rvTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }
}