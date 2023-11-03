package com.example.movieapitask.feature_movie_app.presentation.movie_screen.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieapitask.feature_movie_app.presentation.movie_screen.MovieScreenEvent
import com.example.movieapitask.feature_movie_app.presentation.movie_screen.MovieScreenViewModel
import com.example.movieapitask.feature_movie_app.presentation.movie_screen.components.MovieItem
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MovieScreen(
    viewModel: MovieScreenViewModel = hiltViewModel()
) {

    val state = viewModel.state

    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = viewModel.state.isRefreshing
    )


    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            viewModel.onEvent(MovieScreenEvent.Refresh)
        }
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            state.movies?.let { movie ->

                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {


                    items(movie.size) { i ->
                        val movieResult = movie[i]

                        if (i > 0) {
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        movieResult.results?.forEach() { result ->
                            MovieItem(
                                movieResult = result,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }

                    }
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }


        }
    }

}

