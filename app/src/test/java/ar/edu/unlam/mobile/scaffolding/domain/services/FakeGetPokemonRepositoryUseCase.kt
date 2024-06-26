package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetPokemonRepositoryUseCase

class FakeGetPokemonRepositoryUseCase : GetPokemonRepositoryUseCase {
    override fun getOptions(): List<Pokemon> {
        return listOf(
            Pokemon("Pikachu", "Electric"),
            Pokemon("Charmander", "Fire"),
            Pokemon("Squirtle", "Water"),
            Pokemon("Bulbasaur", "Grass"))
    }
}