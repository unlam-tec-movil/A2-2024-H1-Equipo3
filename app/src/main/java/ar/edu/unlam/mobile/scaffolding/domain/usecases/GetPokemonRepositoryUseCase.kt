package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.services.Pokemon


interface GetPokemonRepositoryUseCase {

    fun getOptions(): List<Pokemon>
}