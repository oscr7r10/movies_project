package com.example.domain.injection

import com.example.domain.api.MoviesAPI
import com.example.domain.datasource.remote.RemoteDataSourceMovies
import com.example.domain.datasource.remote.RemoteDataSourceMoviesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModules {

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        apiService : MoviesAPI
    ) : RemoteDataSourceMovies {
        return RemoteDataSourceMoviesImpl(apiService)
    }

}