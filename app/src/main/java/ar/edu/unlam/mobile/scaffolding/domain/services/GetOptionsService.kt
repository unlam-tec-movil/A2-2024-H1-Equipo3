package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.data.repository.PokemonTestRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetPokemonRepositoryUseCase
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import javax.inject.Inject

class GetOptionsService @Inject constructor(
    private val getPokemonRepository: PokemonTestRepository
) :
    GetOptionsUseCase {
    override fun getOptions(): List<TriviaOption> {
        return getPokemonRepository.getOptions()
            .take(4)
            .mapIndexed { indx, pkmn -> TriviaOption(pkmn, indx == 0) }
            .shuffled()
    }

}


