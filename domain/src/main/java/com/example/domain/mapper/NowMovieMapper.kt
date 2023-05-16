package com.example.domain.mapper

import com.example.domain.datasource.remote.response.DatesResponse
import com.example.domain.datasource.remote.response.NowPlayingResponse
import com.example.domain.datasource.remote.response.ResultNowPlaying
import com.example.domain.model.DatesModel
import com.example.domain.model.NowPlayingModel
import com.example.domain.model.ResultNowPlayingModel

fun NowPlayingResponse.transformToDomain() : NowPlayingModel {
    return NowPlayingModel(
        dates = dates.transformToDomain(),
        page = page,
        results = transformResponseToModel(results),
        total_pages = total_pages,
        total_results = total_results
    )
}

fun DatesResponse.transformToDomain(): DatesModel {
    return DatesModel(
        maximum = maximum,
        minimum = minimum
    )
}

private fun transformResponseToModel(list: List<ResultNowPlaying>) : List<ResultNowPlayingModel>{
    return list.map { item ->
        ResultNowPlayingModel(
            adult = item.adult,
            backdrop_path = item.backdrop_path,
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