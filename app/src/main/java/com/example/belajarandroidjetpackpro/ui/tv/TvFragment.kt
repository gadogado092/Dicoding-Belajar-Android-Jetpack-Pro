package com.example.belajarandroidjetpackpro.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarandroidjetpackpro.databinding.FragmentTvBinding
import com.example.belajarandroidjetpackpro.viewmodel.ViewModelFactory
import com.example.belajarandroidjetpackpro.vo.Status

class TvFragment : Fragment() {

    private lateinit var fragmentTvBinding: FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory,
            )[TvViewModel::class.java]
            val tvAdapter = TvAdapter()

            viewModel.getTv().observe(viewLifecycleOwner, { resTV ->
                if (resTV != null) {
                    when (resTV.status) {
                        Status.LOADING -> fragmentTvBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvBinding.progressBar.visibility = View.GONE
                            tvAdapter.submitList(resTV.data)
                            tvAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentTvBinding.progressBar.visibility = View.GONE
                            Toast.makeText(
                                context,
                                "Terjadi Kesalahan Saat Load Data",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })

            with(fragmentTvBinding.rvTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }
}