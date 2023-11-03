package com.example.movieapitask.feature_movie_app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapitask.feature_movie_app.data.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movieEntity: MovieEntity)

    @Query("DELETE FROM MovieEntity")
    suspend fun clearMovieListing()

    @Query("SELECT * FROM MovieEntity")
    suspend fun getMovie(): List<MovieEntity>?
}