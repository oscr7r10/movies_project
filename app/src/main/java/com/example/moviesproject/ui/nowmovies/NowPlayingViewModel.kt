package com.example.moviesproject.ui.nowmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moviesproject.ui.nowmovies.adapter.NowPagingSource
import com.example.usecases.GetNowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val useCase : GetNowPlayingMoviesUseCase
) : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 20)
    ){
        NowPagingSource(useCase)
    }.flow.cachedIn(viewModelScope)

}