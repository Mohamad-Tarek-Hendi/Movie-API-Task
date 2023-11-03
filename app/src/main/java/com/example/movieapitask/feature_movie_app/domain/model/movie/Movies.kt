package com.example.movieapitask.feature_movie_app.domain.model.movie

data class Movies(
    val page: Int? = null,
    val results: List<MovieResult>? = emptyList(),
    val totalPagesNumber: Int? = null,
    val totalResultNumber: Int? = null
)
