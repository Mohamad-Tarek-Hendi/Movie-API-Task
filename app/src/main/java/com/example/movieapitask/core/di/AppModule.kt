package com.example.movieapitask.core.di

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.example.movieapitask.feature_movie_app.data.local.MovieDatabase
import com.example.movieapitask.feature_movie_app.data.remote.MovieApi
import com.example.movieapitask.feature_movie_app.data.remote.MovieApi.Companion.BASE_URL
import com.example.movieapitask.feature_movie_app.data.repository.MovieRepositoryImpl
import com.example.movieapitask.feature_movie_app.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieApi: MovieApi,
        movieDatabase: MovieDatabase
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieApi, movieDao = movieDatabase.dao
        )
    }

    @Provides
    @Singleton
    fun provideMovieDatabase(application: Application): MovieDatabase {
        return Room.databaseBuilder(
            application,
            MovieDatabase::class.java,
            "movie_db.db"
        ).build()
    }
}