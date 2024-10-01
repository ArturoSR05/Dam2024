package edu.example.dam2024.features.superhero.presentation

import android.content.Context
import edu.example.dam2024.features.superhero.data.SuperheroDataRepository
import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockDataSource
import edu.example.dam2024.features.superhero.domain.GetSuperheroUseCase
import edu.example.dam2024.features.superhero.domain.GetSuperheroesUseCase
import edu.example.dam2024.features.superhero.domain.Superhero
import edu.example.dam2024.features.superhero.domain.SuperheroeRepository

class SuperheroFactory (private val context: Context){

    private val superheroMockRemote = SuperheroMockDataSource()
    private val superheroLocal = SuperheroXmlLocalDataSource(context)
    private val superheroDataRepository = SuperheroDataRepository(superheroLocal, superheroMockRemote)
    private val getSuperheroesUseCase = GetSuperheroesUseCase(superheroDataRepository)
    private val getSuperheroUseCase = GetSuperheroUseCase(superheroDataRepository)

    fun buildViewModel(): SuperheroViewModel{
            return SuperheroViewModel(getSuperheroesUseCase, getSuperheroUseCase)
    }
}