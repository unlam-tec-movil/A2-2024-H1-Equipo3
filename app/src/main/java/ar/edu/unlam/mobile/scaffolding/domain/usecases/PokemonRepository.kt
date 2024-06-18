package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getOptions(optionsAmount:Int,offset: Int): Flow<List<Pokemon>>

    suspend fun getPokemonDetail(id: String): Pokemon
}