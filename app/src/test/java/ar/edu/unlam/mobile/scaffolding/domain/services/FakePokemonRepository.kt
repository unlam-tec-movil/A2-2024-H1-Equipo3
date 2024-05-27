package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.Pokemon
import ar.edu.unlam.mobile.scaffolding.domain.repository.PokemonRepository

class FakePokemonRepository : PokemonRepository {
    override fun getOptions(): List<Pokemon> {
        return listOf(
            Pokemon("Pikachu", "Electric"),
            Pokemon("Charmander", "Fire"),
            Pokemon("Squirtle", "Water"),
            Pokemon("Bulbasaur", "Grass"))
    }
}