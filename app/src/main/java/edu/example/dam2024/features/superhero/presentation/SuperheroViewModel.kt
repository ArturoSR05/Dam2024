package edu.example.dam2024.features.superhero.presentation

import edu.example.dam2024.features.movies.domain.GetMoviesUseCase
import edu.example.dam2024.features.movies.domain.Movie
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.Superhero

class SuperheroViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase,
    private val getSuperheroUseCase: GetSuperheroUseCase) {

    fun viewCreated(): List<Superhero>{
        return getSuperheroesUseCase.invoke()
    }

    fun itemSelected(superheroId: String): Superhero? {
        return getSuperheroUseCase.invoke(superheroId)
    }
}