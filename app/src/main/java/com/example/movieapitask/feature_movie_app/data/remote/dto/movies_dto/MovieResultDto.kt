package com.example.movieapitask.feature_movie_app.data.remote.dto.movies_dto

import com.google.gson.annotations.SerializedName

data class MovieResultDto(
    @SerializedName("adult")
    val isAdult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val categoriesList: List<Int>,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)