package com.example.moviesproject.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.moviesproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LatestMoviesFragment : Fragment() {


    private val viewModel : MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.getLatestMovie()

        return inflater.inflate(R.layout.fragment_latest_movies, container, false)
    }

}