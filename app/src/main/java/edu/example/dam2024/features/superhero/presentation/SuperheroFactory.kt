package edu.example.dam2024.features.superhero.presentation

import edu.example.dam2024.features.superhero.data.SuperheroDataRepository
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockDataSource
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.Superhero
import edu.example.dam2024.features.superhero.domain.SuperheroeRepository

class SuperheroFactory {

    private val superheroMockDataSource = SuperheroMockDataSource()
    private val superheroDataRepository = SuperheroDataRepository(superheroMockDataSource)
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroViewModel{
        return SuperheroViewModel(GetSuperheroesUseCase(SuperheroDataRepository(SuperheroMockDataSource())),
            GetSuperheroUseCase(SuperheroDataRepository(SuperheroMockDataSource()))
        )
    }
}