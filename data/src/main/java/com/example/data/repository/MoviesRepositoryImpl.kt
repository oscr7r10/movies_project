package com.example.data.repository

interface MoviesRepositoryImpl {

    suspend fun getLatestMovies()
    suspend fun getNowPlayingMovies()
    suspend fun getTopRatedMovies()

}