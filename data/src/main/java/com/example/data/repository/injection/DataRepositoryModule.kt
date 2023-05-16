package com.example.data.repository.injection

import com.example.data.repository.MoviesRepository
import com.example.data.repository.MoviesRepositoryImpl
import com.example.domain.datasource.remote.RemoteDataSourceMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataRepositoryModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(
        remoteDataSource : RemoteDataSourceMovies
    ) : MoviesRepositoryImpl {
        return MoviesRepository(remoteDataSource)
    }

}