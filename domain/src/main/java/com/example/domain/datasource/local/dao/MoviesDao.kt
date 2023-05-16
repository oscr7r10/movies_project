package com.example.domain.datasource.local.dao

import androidx.room.Query

interface MoviesDao {

    @Query("")
    fun getAllTopMovies()

    @Query("")
    fun getAllNowMovies()

}