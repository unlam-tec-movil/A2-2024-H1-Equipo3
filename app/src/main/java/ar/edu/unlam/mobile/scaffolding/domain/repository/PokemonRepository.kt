package ar.edu.unlam.mobile.scaffolding.domain.repository

import ar.edu.unlam.mobile.scaffolding.domain.services.Pokemon


interface PokemonRepository {

    fun getOptions(): List<Pokemon>
}