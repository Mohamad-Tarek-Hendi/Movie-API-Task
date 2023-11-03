package com.example.movieapitask.feature_movie_app.presentation.movie_screen

sealed class MovieScreenEvent {
    object Refresh : MovieScreenEvent()
}
