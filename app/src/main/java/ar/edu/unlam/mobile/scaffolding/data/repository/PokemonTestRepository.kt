package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object PokemonTestRepository : PokemonRepository {

    val bulbasaur = Pokemon("Bulbasaur", "Planta", R.drawable.bulbasaur)

    val charmander = Pokemon("Charmander", "Fuego", R.drawable.charmander)

    val squirtle = Pokemon("Squirtle", "Agua", R.drawable.squirtle)

    val pikachu = Pokemon("Pikachu", "Electrico", R.drawable.pikachu)

    val PokemonRepository = mutableListOf(bulbasaur, charmander, squirtle, pikachu)

    override fun getOptions(): Flow<List<Pokemon>> {
        return flow {
            emit(PokemonRepository)
        }
    }

    //    fun obtenerPokemon(): Pokemon {
    //  var nAleatorio = Random()
    //return PokemonRepository[nAleatorio.nextInt(3)]
    //}

}