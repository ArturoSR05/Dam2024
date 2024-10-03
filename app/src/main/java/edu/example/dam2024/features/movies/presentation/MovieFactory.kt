package edu.example.dam2024.features.movies.presentation

import android.content.Context
import edu.example.dam2024.features.movies.data.MovieDataRepository
import edu.example.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.example.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.example.dam2024.features.movies.domain.GetMovieUseCase
import edu.example.dam2024.features.movies.domain.GetMoviesUseCase

class MovieFactory (private val context: Context){

    private val movieMockRemote = MovieMockRemoteDataSource()
    private val movieLocal = MovieXmlLocalDataSource(context)
    private val movieDataRepository = MovieDataRepository(movieLocal, movieMockRemote)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)

    fun buildViewModel(): MoviesViewModel{
        return MoviesViewModel(getMoviesUseCase, getMovieUseCase)
    }

    fun buildMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel()
    }
}