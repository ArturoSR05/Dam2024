package edu.example.dam2024.features.superhero.data

import edu.example.dam2024.features.superhero.data.remote.SuperheroMockDataSource
import edu.example.dam2024.features.superhero.domain.Superhero
import edu.example.dam2024.features.superhero.domain.SuperheroeRepository

class SuperheroDataRepository(private val mockDataSource: SuperheroMockDataSource):
    SuperheroeRepository {
        override fun getSuperheroes(): List<Superhero>{
            return mockDataSource.getSuperheroes()
        }

        override fun getSuperhero(superheroId: String): Superhero? {
        return mockDataSource.getSuperheroe(superheroId)
        }


    }