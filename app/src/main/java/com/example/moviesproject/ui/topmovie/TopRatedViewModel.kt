package com.example.moviesproject.ui.topmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moviesproject.ui.topmovie.adapter.TopPagingSource
import com.example.usecases.GetTopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopRatedViewModel @Inject constructor(
    private val useCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 20)
    ){
        TopPagingSource(useCase)
    }.flow.cachedIn(viewModelScope)

}