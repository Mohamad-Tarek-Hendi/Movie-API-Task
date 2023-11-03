package com.example.movieapitask.feature_movie_app.domain.repository

import com.example.movieapitask.core.constant.Resource
import com.example.movieapitask.feature_movie_app.domain.model.movie.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMoviesResult(
        category: String,
        fetchFromRemote: Boolean,
    ): Flow<Resource<List<Movies>>>

}