package com.example.domain.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.datasource.local.dao.MoviesDao
import com.example.domain.model.ResultTopModel

@Database(
    entities = [ResultTopModel::class],
    version = 1
)
abstract class MovieDb : RoomDatabase(){

    abstract fun movieDbDao() : MoviesDao

}