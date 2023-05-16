package com.example.moviesproject.ui.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.LatestMovieModel
import com.example.domain.model.NowPlayingModel
import com.example.domain.model.TopRatedModel
import com.example.domain.util.ResultApi
import com.example.usecases.GetLatestMoviesUseCase
import com.example.usecases.GetNowPlayingMoviesUseCase
import com.example.usecases.GetTopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val latestMovieUseCase: GetLatestMoviesUseCase,
    private val nowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val topRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel(){

    private val _latestMovies = MutableStateFlow(LatestMovieModel())
    val latestMovie : StateFlow<LatestMovieModel> get() = _latestMovies

    private val _nowPlayingMovies = MutableStateFlow(NowPlayingModel())
    val nowPlayingMovies : StateFlow<NowPlayingModel> get() = _nowPlayingMovies

    private val _topRatedMovies = MutableStateFlow(TopRatedModel())
    val topRatedMovies : StateFlow<TopRatedModel> get() = _topRatedMovies

    fun getLatestMovie(){
        viewModelScope.launch (Dispatchers.IO){
            latestMovieUseCase.invoke().collect{ result ->
                when(result){
                    is ResultApi.OnFailure -> TODO()
                    ResultApi.OnLoading -> TODO()
                    is ResultApi.OnSuccess -> {
                        Log.e("RESULT_DATA", result.data.toString())
                         _latestMovies.value = result.data
                    }
                }
            }
        }
    }

    fun getTopRatedMovie(){
        viewModelScope.launch(Dispatchers.IO) {
            topRatedMoviesUseCase.invoke(1).collect { result ->
                when (result) {
                    is ResultApi.OnFailure -> TODO()
                    ResultApi.OnLoading -> TODO()
                    is ResultApi.OnSuccess -> {
                        Log.e("RESULT_DATA_TOP", result.data.toString())
                        _topRatedMovies.value = result.data
                    }
                }
            }
        }
    }

}