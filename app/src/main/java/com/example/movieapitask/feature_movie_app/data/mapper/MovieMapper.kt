package com.example.movieapitask.feature_movie_app.data.mapper

import com.example.movieapitask.feature_movie_app.data.local.entity.MovieEntity
import com.example.movieapitask.feature_movie_app.data.remote.dto.movies_dto.MovieResultDto
import com.example.movieapitask.feature_movie_app.data.remote.dto.movies_dto.MoviesDto
import com.example.movieapitask.feature_movie_app.domain.model.movie.MovieResult
import com.example.movieapitask.feature_movie_app.domain.model.movie.Movies

fun MoviesDto.toMoviesEntity(): MovieEntity {
    return MovieEntity(
        page = page,
        results = results,
        totalPagesNumber = totalPagesNumber,
        totalResultNumber = totalResultNumber
    )
}

fun MovieEntity.toMovies(): Movies {
    return Movies(
        page = page,
        results = results.map {
            it.toMoviesResult()
        },
        totalPagesNumber = totalPagesNumber,
        totalResultNumber = totalResultNumber
    )
}

fun MovieResultDto.toMoviesResult(): MovieResult {
    return MovieResult(
        isAdult = isAdult,
        categoriesList = categoriesList,
        movieId = movieId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}
