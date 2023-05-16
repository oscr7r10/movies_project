package com.example.domain.mapper

import com.example.domain.datasource.remote.response.ResultTop
import com.example.domain.datasource.remote.response.TopRatedResponse
import com.example.domain.model.ResultTopModel
import com.example.domain.model.TopRatedModel

fun TopRatedResponse.transformToDomain() : TopRatedModel{
    return TopRatedModel(
        page = page,
        results = transformResponseToModel(results),
        total_pages = total_pages,
        total_results = total_results
    )
}

private fun transformResponseToModel(list: List<ResultTop>):List<ResultTopModel>{
    return list.map { item ->
        ResultTopModel(
            adult = item.adult,
            backdrop_path = item.backdrop_path?:"",
            genre_ids = item.genre_ids,
            id = item.id,
            original_language = item.original_language,
            original_title = item.original_title,
            overview = item.overview,
            popularity = item.popularity,
            poster_path = item.poster_path,
            release_date = item.release_date,
            title = item.title,
            video = item.video,
            vote_average = item.vote_average,
            vote_count = item.vote_count
        )
    }
}