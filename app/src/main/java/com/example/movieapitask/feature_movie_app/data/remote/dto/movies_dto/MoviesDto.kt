package com.example.movieapitask.feature_movie_app.data.remote.dto.movies_dto

import com.google.gson.annotations.SerializedName

data class MoviesDto(
    val page: Int,
    val results: List<MovieResultDto>,
    @SerializedName("total_pages")
    val totalPagesNumber: Int,
    @SerializedName("total_results")
    val totalResultNumber: Int
)
