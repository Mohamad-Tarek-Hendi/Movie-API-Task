package com.example.movieapitask.feature_movie_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.movieapitask.feature_movie_app.data.local.converter.MovieResultDtoConverter
import com.example.movieapitask.feature_movie_app.data.remote.dto.movies_dto.MovieResultDto

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val page: Int,
    @TypeConverters(MovieResultDtoConverter::class)
    val results: List<MovieResultDto>,
    val totalPagesNumber: Int,
    val totalResultNumber: Int
)
