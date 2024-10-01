package edu.example.dam2024.features.superhero.data

import edu.example.dam2024.features.superhero.data.local.SuperheroXmlLocalDataSource
import edu.example.dam2024.features.superhero.data.remote.SuperheroMockDataSource
import edu.example.dam2024.features.superhero.domain.Superhero
import edu.example.dam2024.features.superhero.domain.SuperheroeRepository

class SuperheroDataRepository(
    private val local: SuperheroXmlLocalDataSource,
    private val mockDataSource: SuperheroMockDataSource):
    SuperheroeRepository {
        override fun getSuperheroes(): List<Superhero>{
            val superheroesFromLocal = local.findAll()
            if (superheroesFromLocal.isEmpty()){
                val superheroesFromRemote = mockDataSource.getSuperheroes()
                local.saveAll(superheroesFromRemote)
                return superheroesFromRemote
            } else {
                return superheroesFromLocal
            }
        }

        override fun getSuperhero(superheroId: String): Superhero? {
        return mockDataSource.getSuperheroe(superheroId)
        }


    }