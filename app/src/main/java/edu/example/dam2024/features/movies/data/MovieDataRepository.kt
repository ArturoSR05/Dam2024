package edu.example.dam2024.features.movies.data

import edu.example.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.example.dam2024.features.movies.domain.Movie
import edu.example.dam2024.features.movies.domain.MovieRepository

class MovieDataRepository (private val mockRemoteDataSource: MovieMockRemoteDataSource):
    MovieRepository{

    override fun getMovies(): List<Movie>{
        return mockRemoteDataSource.getMovies()
    }

    override fun getMovie(movieId: String): Movie? {
        return mockRemoteDataSource.getMovie(movieId)
    }

}