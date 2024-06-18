package ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote

import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.PokemonDto
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.list.PokemonListDto

interface PokemonRemoteSource {
    suspend fun getPokemonList(limit: Int,offset: Int): PokemonListDto
    suspend fun getPokemonDetail(id:String): PokemonDto
}