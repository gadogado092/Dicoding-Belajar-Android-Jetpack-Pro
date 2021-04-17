package com.example.belajarandroidjetpackpro.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarandroidjetpackpro.databinding.FragmentMovieFavoriteBinding
import com.example.belajarandroidjetpackpro.viewmodel.ViewModelFactory

class MovieFavoriteFragment : Fragment() {

    private lateinit var fragmentFavoriteMovieBinding: FragmentMovieFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteMovieBinding =
            FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity !=null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieFavoriteViewModel::class.java]
            val movieAdapter = MovieFavoriteAdapter()

            fragmentFavoriteMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovie().observe(viewLifecycleOwner,{ movies->
                fragmentFavoriteMovieBinding.progressBar.visibility = View.GONE
                movieAdapter.submitList(movies)
                movieAdapter.notifyDataSetChanged()
                if (movies.isEmpty()){
                    fragmentFavoriteMovieBinding.tvNoData.visibility = View.VISIBLE
                }else{
                    fragmentFavoriteMovieBinding.tvNoData.visibility = View.GONE
                }
            })

            with(fragmentFavoriteMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}