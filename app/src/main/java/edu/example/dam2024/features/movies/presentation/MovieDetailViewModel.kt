package edu.example.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.example.dam2024.features.movies.domain.GetMovieUseCase
import edu.example.dam2024.features.movies.domain.Movie

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase): ViewModel(){
        fun viewCreated(movieId: String): Movie?{
            return getMovieUseCase.invoke(movieId)
        }
    }




