package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.Pokemon
import ar.edu.unlam.mobile.scaffolding.domain.repository.PokemonRepository

object PokemonTestRepository : PokemonRepository {

    val bulbasaur = Pokemon("Bulbasaur", "Planta")

    val charmander = Pokemon("Charmander", "Fuego")

    val squirtle = Pokemon("Squirtle", "Agua")
    val pikachu = Pokemon("Pikachu", "Electrico")

    val PokemonRepository = mutableListOf(bulbasaur, charmander, squirtle, pikachu)
    override fun getOptions(): List<Pokemon> {
        return PokemonRepository
    }

}