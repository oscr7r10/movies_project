package com.example.usecases

import com.example.data.repository.MoviesRepositoryImpl
import com.example.domain.model.NowPlayingModel
import com.example.domain.util.ResultApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(private val repository : MoviesRepositoryImpl) {

    operator fun invoke(page : Int) : Flow<ResultApi<NowPlayingModel>> {
        return repository.getNowPlayingMovies(page)
    }

}