package ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model

import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.detail.Sprites

data class PokemonDto(
    val id: String,
    val name: String,
    val sprites: Sprites,
)