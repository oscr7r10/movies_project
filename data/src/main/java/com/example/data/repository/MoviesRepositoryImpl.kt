package com.example.data.repository

import com.example.domain.model.LatestMovieModel
import com.example.domain.model.NowPlayingModel
import com.example.domain.model.TopRatedModel
import com.example.domain.util.ResultApi
import kotlinx.coroutines.flow.Flow

interface MoviesRepositoryImpl {

    fun getLatestMovies() : Flow<ResultApi<LatestMovieModel>>
    fun getNowPlayingMovies(page : Int) : Flow<ResultApi<NowPlayingModel>>
    fun getTopRatedMovies(page : Int) : Flow<ResultApi<TopRatedModel>>

}