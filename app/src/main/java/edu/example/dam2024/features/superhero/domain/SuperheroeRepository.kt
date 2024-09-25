package edu.example.dam2024.features.superhero.domain

interface SuperheroeRepository {

    fun getSuperheroes(): List<Superhero>
    fun getSuperhero(superheroId: String): Superhero?
}