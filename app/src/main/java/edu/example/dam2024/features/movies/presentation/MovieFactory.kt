package edu.example.dam2024.features.movies.presentation

import edu.example.dam2024.features.movies.data.MovieDataRepository
import edu.example.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.example.dam2024.features.movies.domain.GetMovieUseCase
import edu.example.dam2024.features.movies.domain.GetMoviesUseCase

class MovieFactory {

    fun buildViewModel(): MovieViewModel{

        return MovieViewModel(GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource())),
            GetMovieUseCase(MovieDataRepository(MovieMockRemoteDataSource()))
        )
    }
}