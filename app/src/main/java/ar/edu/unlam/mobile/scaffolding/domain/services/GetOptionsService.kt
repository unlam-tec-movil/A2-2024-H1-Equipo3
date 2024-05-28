package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import javax.inject.Inject

class GetOptionsService @Inject constructor(
    private val pokemonRepository: PokemonRepository
) :
    GetOptionsUseCase {
    override fun getOptions(): List<TriviaOption> {
        return pokemonRepository.getOptions()
            .take(4)
            .mapIndexed { indx, pkmn -> TriviaOption(pkmn, indx == 0) }
            .shuffled()
    }

    fun obtenerPokemonCorrecto() : Pokemon? {
        getOptions().forEach(){
            if (it.isCorrect){return it.option}
        }
        return null
    }
}


