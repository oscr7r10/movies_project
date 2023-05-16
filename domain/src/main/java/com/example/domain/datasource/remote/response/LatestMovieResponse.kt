package com.example.domain.datasource.remote.response

import com.google.gson.annotations.SerializedName

data class LatestMovieResponse(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdrop_path: Any? = null,
    @SerializedName("belongs_to_collection")
    val belongs_to_collection: Any? = null,
    @SerializedName("budget")
    val budget: Int = 0,
    @SerializedName("genres")
    val genres: List<Genre>? = null,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdb_id: Any? = null,
    @SerializedName("original_language")
    val original_language: String,
    @SerializedName("original_title")
    val original_title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: Any?= null,
    @SerializedName("production_companies")
    val production_companies: List<Any>,
    @SerializedName("production_countries")
    val production_countries: List<Any>,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("spoken_languages")
    val spoken_languages: List<Any>,
    @SerializedName("status")
    val status: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("vote_count")
    val vote_count: Int
)

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)