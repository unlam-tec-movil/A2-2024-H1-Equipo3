package ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository

import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.PokemonRemoteSource
import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonRemoteDataSource: PokemonRemoteSource) :
    PokemonRepository {
    override fun getOptions(optionsAmount: Int, offset: Int): Flow<List<Pokemon>> {
        return flow {
            emit(pokemonRemoteDataSource.getPokemonList(optionsAmount, offset).toPokemon())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getPokemonDetail(id: String): Pokemon {
        return withContext(Dispatchers.IO) {
            pokemonRemoteDataSource.getPokemonDetail(id).toPokemon()
        }
    }


}