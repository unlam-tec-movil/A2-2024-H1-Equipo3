package ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote

import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.PokemonDto

interface RemoteSource {

    fun getPokemon(): PokemonDto
}