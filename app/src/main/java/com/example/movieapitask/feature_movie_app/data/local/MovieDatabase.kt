package com.example.movieapitask.feature_movie_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieapitask.feature_movie_app.data.local.converter.MovieResultDtoConverter
import com.example.movieapitask.feature_movie_app.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(MovieResultDtoConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract val dao: MovieDao
}