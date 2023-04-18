package com.example.domain.util

import com.example.domain.api.MoviesAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ServiceApi {

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/movie/")
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = retrofitBuilder.build()

    private val moviesAPI = retrofit.create(MoviesAPI::class.java)

    fun getMoviesApi() : MoviesAPI{
        return moviesAPI
    }

}