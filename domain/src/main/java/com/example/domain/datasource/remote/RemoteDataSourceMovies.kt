package com.example.domain.datasource.remote

import com.example.domain.model.LatestMovieModel
import com.example.domain.model.NowPlayingModel
import com.example.domain.model.TopRatedModel
import com.example.domain.util.ResultApi

interface RemoteDataSourceMovies {
    suspend fun getLatestMovies(): ResultApi<LatestMovieModel>
    suspend fun getNowPlayingMovies(page : Int): ResultApi<NowPlayingModel>
    suspend fun getTopRatedMovies(page : Int): ResultApi<TopRatedModel>
}