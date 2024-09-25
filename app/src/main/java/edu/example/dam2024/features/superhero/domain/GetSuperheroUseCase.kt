package edu.example.dam2024.features.superhero.domain

class GetSuperheroUseCase(private val superheroeRepository: SuperheroeRepository) {

    operator fun invoke(superheroId: String): Superhero?{
        return superheroeRepository.getSuperhero(superheroId)
    }
}