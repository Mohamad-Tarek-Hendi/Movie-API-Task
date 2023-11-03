package com.example.movieapitask.feature_movie_app.data.remote

import com.example.movieapitask.feature_movie_app.data.remote.dto.movies_dto.MoviesDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{category}")
    suspend fun getMovies(
        @Header("Authorization") authorization: String = "Bearer $Authorization",
        @Path("category")
        category: String,
        @Query("page")
        page: Int = 1
    ): MoviesDto


    companion object {
        const val Authorization =
            "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3MGJhMDYzMDM3ZmJjZGU1MGFjMjZlNzFkNGE4Nzc2YiIsInN1YiI6IjYxNjZiMDA4ZDdmNDY1MDA0MjQ3ZWUwZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.F9qSlScGTilHv2fiTsi0Bk_5SbMspBsk0tXJPaWbPOA"
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}
