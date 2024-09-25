package edu.example.dam2024.features.superhero.data.remote

import edu.example.dam2024.features.superhero.domain.Superhero

class SuperheroMockDataSource {

    private val superheroes = listOf(
            Superhero("1", "Fly", "Iron Man"),
            Superhero("2", "throw spider web", "Spiderman"),
            Superhero("3", "is a God", "Thor")
    )

    fun getSuperheroes(): List<Superhero> {
        return superheroes
    }

    fun getSuperheroe(superheroeId: String): Superhero? {
        return superheroes.firstOrNull()
    }


}