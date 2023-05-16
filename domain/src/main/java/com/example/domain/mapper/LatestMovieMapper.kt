package com.example.domain.mapper

import com.example.domain.datasource.remote.response.Genre
import com.example.domain.datasource.remote.response.LatestMovieResponse
import com.example.domain.model.Genresa
import com.example.domain.model.LatestMovieModel

fun LatestMovieResponse.transformToDomain(): LatestMovieModel {
    return LatestMovieModel(
        adult = adult,
        genres = mapperGenres(genres?: emptyList()),
        homepage = homepage,
        id = id,
        imdb_id = imdb_id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )
}

private fun mapperGenres(list: List<Genre>): List<Genresa> {
    return list.map { genre ->
        Genresa(
            id = genre.id,
            name = genre.name
        )
    }
}
