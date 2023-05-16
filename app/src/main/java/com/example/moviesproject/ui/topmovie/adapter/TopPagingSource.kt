package com.example.moviesproject.ui.topmovie.adapter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.model.ResultTopModel
import com.example.domain.model.TopRatedModel
import com.example.domain.util.ResultApi
import com.example.usecases.GetTopRatedMoviesUseCase

class TopPagingSource(private val useCase: GetTopRatedMoviesUseCase) :
    PagingSource<Int, ResultTopModel>() {

    override fun getRefreshKey(state: PagingState<Int, ResultTopModel>): Int? {

        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null

        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultTopModel> {

        return try {
            val nextPageNumber = params.key ?: 1
            val list = mutableListOf<ResultTopModel>()
            var response = TopRatedModel()

            useCase.invoke(nextPageNumber).collect { result ->
                when (result) {
                    is ResultApi.OnFailure -> TODO()
                    ResultApi.OnLoading -> TODO()
                    is ResultApi.OnSuccess -> {
                        response = result.data
                    }
                }
            }


            list.addAll(response.results?.toMutableList()?: emptyList())

            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = response.page+1
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}