package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.Pokemon

object PokemonTestRepository {

        val bulbasaur = Pokemon("Bulbasaur", "Planta")

        val charmander = Pokemon("Charmander", "Fuego")

        val squirtle = Pokemon("Squirtle", "Agua")

        val PokemonRepository = mutableListOf(bulbasaur, charmander, squirtle)

}