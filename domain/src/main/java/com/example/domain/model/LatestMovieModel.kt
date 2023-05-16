package com.example.domain.model

data class LatestMovieModel(
    val adult: Boolean = false,
    val genres: List<Genresa>? = emptyList(),
    val homepage: String ="",
    val id: Int = 0,
    val imdb_id: Any? = null,
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: Any?= null,
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class Genresa(
    val id: Int = 0,
    val name: String = ""
)