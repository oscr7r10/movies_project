package com.example.domain.api

import com.example.domain.datasource.remote.response.LatestMovieResponse
import com.example.domain.datasource.remote.response.NowPlayingResponse
import com.example.domain.datasource.remote.response.TopRatedResponse
import com.example.domain.util.ResultApi
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET("latest")
    suspend fun getLatestMovies() : LatestMovieResponse

    @GET("now_playing")
    suspend fun getNowPlayingMovies(
        @Query(value = "page") page : Int
    ) : NowPlayingResponse

    @GET("top_rated")
    suspend fun getTopRatedMovies(
        @Query(value = "page") page : Int
    ) : TopRatedResponse

}