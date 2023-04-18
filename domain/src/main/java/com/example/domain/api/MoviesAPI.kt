package com.example.domain.api

import com.example.domain.util.ResultApi
import retrofit2.http.GET

interface MoviesAPI {

    @GET("/latest")
    suspend fun getLatestMovies() : ResultApi<Nothing>

    @GET("/now_playing")
    suspend fun getNowPlayingMovies() : ResultApi<Nothing>

    @GET("/top_rated")
    suspend fun getTopRatedMovies() : ResultApi<Nothing>

}