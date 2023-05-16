package com.example.data.repository

import com.example.domain.datasource.remote.RemoteDataSourceMovies
import com.example.domain.model.LatestMovieModel
import com.example.domain.model.NowPlayingModel
import com.example.domain.model.TopRatedModel
import com.example.domain.util.ResultApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesRepository(
    private val remoteDataSource : RemoteDataSourceMovies,
    //private val localDataSource : LocalDataSource
) : MoviesRepositoryImpl{
    override fun getLatestMovies(): Flow<ResultApi<LatestMovieModel>> = flow {
        when(val result = remoteDataSource.getLatestMovies()){
            is ResultApi.OnFailure -> TODO()
            ResultApi.OnLoading -> emit(ResultApi.OnLoading)
            is ResultApi.OnSuccess -> emit(result)
        }
    }

    override fun getNowPlayingMovies(page : Int): Flow<ResultApi<NowPlayingModel>> = flow{
        when(val result = remoteDataSource.getNowPlayingMovies(page)){
            is ResultApi.OnFailure -> TODO()
            ResultApi.OnLoading -> emit(ResultApi.OnLoading)
            is ResultApi.OnSuccess -> emit(result)
        }
    }

    override fun getTopRatedMovies(page : Int): Flow<ResultApi<TopRatedModel>> = flow {
        when(val result = remoteDataSource.getTopRatedMovies(page)){
            is ResultApi.OnFailure -> TODO()
            ResultApi.OnLoading -> emit(ResultApi.OnLoading)
            is ResultApi.OnSuccess -> emit(result)
        }
    }

}