package com.example.movieapitask.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.movieapitask.core.presentation.ui.theme.MovieApiTaskTheme
import com.example.movieapitask.feature_movie_app.presentation.movie_screen.base.MovieScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApiTaskTheme {

                MovieScreen()

            }
        }
    }
}
