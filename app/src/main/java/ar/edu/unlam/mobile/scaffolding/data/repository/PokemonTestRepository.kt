package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.domain.services.Pokemon
import ar.edu.unlam.mobile.scaffolding.R
import java.util.Random

object PokemonTestRepository {

        val bulbasaur = Pokemon("Bulbasaur", "Planta", R.drawable.bulbasaur)

        val charmander = Pokemon("Charmander", "Fuego", R.drawable.charmander)

        val squirtle = Pokemon("Squirtle", "Agua",R.drawable.squirtle)

        val PokemonRepository = mutableListOf(bulbasaur, charmander, squirtle)

        fun obtenerPokemon(): Pokemon {
                var nAleatorio = Random()
                return PokemonRepository[nAleatorio.nextInt(3)]
        }

}