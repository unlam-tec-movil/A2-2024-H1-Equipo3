package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaGame
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.model.toTriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetOptionsService @Inject constructor(
    private val getPokemonRepository: PokemonRepository
) : GetOptionsUseCase {

    companion object {
        private const val optionsAmount = 4
    }



    override fun getNewGame(): Flow<TriviaGame> {
        return flow {
             val offset: Int = (0..500).random()

            getPokemonRepository.getOptions(optionsAmount, offset)
                .collect { pokemons ->
                    var correctOption: TriviaOption? = null
                    val triviaOptions = pokemons
                        .shuffled()
                        .mapIndexed { index, pokemon ->
                            if (index == 0) {
                                val pokemonDetail =
                                    getPokemonRepository.getPokemonDetail(pokemon.name)
                                correctOption =
                                    pokemonDetail.toTriviaOption().copy(isCorrect = true)
                                correctOption!!
                            } else {
                                pokemon.toTriviaOption()
                            }
                        }
                        .shuffled()
                    emit(TriviaGame(triviaOptions, correctOption!!))
                }
        }
    }
}


