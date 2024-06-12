package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository

class FakeGetPokemonRepositoryUseCase : PokemonRepository {
    override fun getOptions(): Flow<List<Pokemon>> {
        return listOf(
            Pokemon("Pikachu", "Electric"),
            Pokemon("Charmander", "Fire"),
            Pokemon("Squirtle", "Water"),
            Pokemon("Bulbasaur", "Grass")
        )
    }
}