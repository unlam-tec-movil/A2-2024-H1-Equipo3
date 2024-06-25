package ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote

import ar.edu.unlam.mobile.scaffolding.data.network.PokemonService
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.safeApiCall
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.PokemonDto
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.list.PokemonListDto
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.toPokemonDto
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(private val pokemonService: PokemonService) :
    PokemonRemoteSource {
    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonListDto = safeApiCall {
        pokemonService.getPokemons(limit, offset)
    }

    override suspend fun getPokemonDetail(id: String): PokemonDto = safeApiCall{
        pokemonService.getPokemonDetail(id).toPokemonDto(id)
    }
}