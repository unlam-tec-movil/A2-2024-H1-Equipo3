package ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository

import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.detail.PokemonResponse
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.PokemonDto
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.remote.model.list.PokemonListDto
import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon

fun PokemonDto.toPokemon(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        image = sprites.other.officialArtwork.front_default ?: sprites.front_default,
    )
}

fun PokemonListDto.toPokemon(): List<Pokemon> {
    return results.map { Pokemon(id = it.url.getIdFromPath(), name = it.name, image = "") }
}

fun PokemonResponse.toPokemonDto(id:String): PokemonDto {
    return PokemonDto(
        id = id,
        name = name,
        sprites = sprites
    )
}

private fun String.getIdFromPath(): String{
    return this[this.lastIndexOf('/') - 1].toString()
}

