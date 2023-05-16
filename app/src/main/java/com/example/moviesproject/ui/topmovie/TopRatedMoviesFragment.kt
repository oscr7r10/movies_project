package com.example.moviesproject.ui.topmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesproject.databinding.FragmentTopRatedMoviesBinding
import com.example.moviesproject.ui.topmovie.adapter.TopMovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopRatedMoviesFragment : Fragment() {

    private lateinit var binding : FragmentTopRatedMoviesBinding
    private lateinit var mAdapter : TopMovieAdapter
    private val viewModel : TopRatedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopRatedMoviesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()
        loadData()

    }

    private fun configRecycler(){
        mAdapter = TopMovieAdapter()

        binding.recyclerTop.apply {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    private fun loadData(){
        lifecycleScope.launch {
            viewModel.flow.collect{
                mAdapter.submitData(it)
            }
        }
    }

}