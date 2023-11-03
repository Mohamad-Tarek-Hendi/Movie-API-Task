package com.example.movieapitask.feature_movie_app.presentation.movie_screen

import com.example.movieapitask.feature_movie_app.domain.model.movie.Movies

data class MovieScreenState(
    val movies: List<Movies>? = emptyList(),
    val isRefreshing: Boolean = false,
    val isLoading: Boolean = false,
    val error: String = ""
)

