package com.example.domain.model


data class NowPlayingModel(
    val dates: DatesModel? = null,
    val page: Int = 0,
    val results: List<ResultNowPlayingModel>? = emptyList(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

data class ResultNowPlayingModel(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: List<Int> = emptyList(),
    val id: Int = 0,
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

data class DatesModel(
    val maximum: String = "",
    val minimum: String = ""
)