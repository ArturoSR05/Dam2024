package edu.example.dam2024.features.superhero.domain

class GetSuperheroesUseCase(private val superheroeRepository: SuperheroeRepository) {

    operator fun invoke(): List<Superhero>{
        return superheroeRepository.getSuperheroes()
    }
}