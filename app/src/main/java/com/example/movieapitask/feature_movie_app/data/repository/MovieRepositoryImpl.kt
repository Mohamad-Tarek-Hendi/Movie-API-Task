package com.example.movieapitask.feature_movie_app.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.movieapitask.core.constant.Resource
import com.example.movieapitask.feature_movie_app.data.local.MovieDao
import com.example.movieapitask.feature_movie_app.data.mapper.toMovies
import com.example.movieapitask.feature_movie_app.data.mapper.toMoviesEntity
import com.example.movieapitask.feature_movie_app.data.remote.MovieApi
import com.example.movieapitask.feature_movie_app.domain.model.movie.Movies
import com.example.movieapitask.feature_movie_app.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao
) : MovieRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getMoviesResult(
        category: String,
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Movies>>> {
        return flow {

            emit(Resource.Loading(true))

            val localListing = movieDao.getMovie()

            emit(
                Resource.Success(
                    data = localListing?.map {
                        it.toMovies()
                    }
                )
            )

            val shouldJustLoadFromCache = !localListing.isNullOrEmpty() && !fetchFromRemote

            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }


            val remoteListing = try {
                movieApi.getMovies(category = category)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't Load Data, Swipe To Refresh"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't Reach Server, Check Your Internet Connection."))
                null
            }

            remoteListing?.let { movie ->
                movieDao.clearMovieListing()
                movieDao.saveMovies(movie.toMoviesEntity())
                emit(
                    Resource.Success(data = movieDao.getMovie()?.map {
                        it.toMovies()
                    })
                )
                emit(Resource.Error(message = ""))

                emit(Resource.Loading(false))
            }
        }
    }

}