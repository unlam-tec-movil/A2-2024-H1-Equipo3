package ar.edu.unlam.mobile.scaffolding.domain.repository

import ar.edu.unlam.mobile.scaffolding.Pokemon

interface PokemonRepository {

    fun getOptions(): List<Pokemon>
}