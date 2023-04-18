package com.example.usecases

import com.example.data.repository.MoviesRepositoryImpl
import javax.inject.Inject

class GetLatestMoviesUseCase @Inject constructor(private val repository : MoviesRepositoryImpl) {

    operator fun invoke() : String{
        return ""
    }

}