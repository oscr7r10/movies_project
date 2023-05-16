package com.example.domain.datasource.remote.response

import com.google.gson.annotations.SerializedName

data class TopRatedResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultTop>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)

data class ResultTop(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdrop_path: String? = "",
    @SerializedName("genre_ids")
    val genre_ids: List<Int> = emptyList(),
    @SerializedName("id")
    val id: Int= 0,
    @SerializedName("original_language")
    val original_language: String = "",
    @SerializedName("original_title")
    val original_title: String = "",
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("poster_path")
    val poster_path: String = "",
    @SerializedName("release_date")
    val release_date: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("vote_average")
    val vote_average: Double = 0.0,
    @SerializedName("vote_count")
    val vote_count: Int = 0
)