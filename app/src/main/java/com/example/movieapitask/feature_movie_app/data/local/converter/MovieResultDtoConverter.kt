package com.example.movieapitask.feature_movie_app.data.local.converter

import androidx.room.TypeConverter
import com.example.movieapitask.feature_movie_app.data.remote.dto.movies_dto.MovieResultDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieResultDtoConverter {
    @TypeConverter
    fun fromJson(json: String): List<MovieResultDto> {
        val type = object : TypeToken<List<MovieResultDto>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(list: List<MovieResultDto>): String {
        return Gson().toJson(list)
    }
}