package com.example.moviesproject.ui.nowmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesproject.databinding.FragmentNowPlayingMoviesBinding
import com.example.moviesproject.ui.nowmovies.adapter.NowMovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class NowPlayingMoviesFragment : Fragment() {

    private lateinit var binding : FragmentNowPlayingMoviesBinding
    private lateinit var mAdapter : NowMovieAdapter
    private val viewModel : NowPlayingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNowPlayingMoviesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()
        loadData()
    }

    private fun configRecycler(){
        mAdapter = NowMovieAdapter()

        binding.recyclerNow.apply {
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