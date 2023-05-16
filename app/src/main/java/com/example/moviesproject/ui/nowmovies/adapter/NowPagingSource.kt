package com.example.moviesproject.ui.nowmovies.adapter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.model.NowPlayingModel
import com.example.domain.model.ResultNowPlayingModel
import com.example.domain.util.ResultApi
import com.example.usecases.GetNowPlayingMoviesUseCase

class NowPagingSource(private val useCase: GetNowPlayingMoviesUseCase) :
    PagingSource<Int, ResultNowPlayingModel>() {

    override fun getRefreshKey(state: PagingState<Int, ResultNowPlayingModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null

        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultNowPlayingModel> {

        return try {
            val nextPageNumber = params.key ?: 1
            val list = mutableListOf<ResultNowPlayingModel>()
            var response = NowPlayingModel()

            useCase.invoke(nextPageNumber).collect(){result ->
                when(result) {
                    is ResultApi.OnFailure -> TODO()
                    ResultApi.OnLoading -> TODO()
                    is ResultApi.OnSuccess -> {
                        response = result.data
                    }
                }
            }

            list.addAll(response.results?.toMutableList() ?: emptyList())

            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = response.page + 1
            )

        }catch (e : Exception){
            LoadResult.Error(e)
        }

    }
}