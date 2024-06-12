package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaGame
import ar.edu.unlam.mobile.scaffolding.domain.model.toTriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import ar.edu.unlam.mobile.scaffolding.domain.usecases.PokemonRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetOptionsService @Inject constructor(
    private val getPokemonRepository: PokemonRepository
) : GetOptionsUseCase {
    override fun getNewGame(): Flow<TriviaGame> {
        return flow {
            getPokemonRepository.getOptions()
                .collect {
                    val triviaOptions = it.map {
                        it.toTriviaOption()
                    }
                        .take(4)
                        .shuffled()
                    val correctOption = triviaOptions.first()
                    triviaOptions.first().isCorrect = true
                    triviaOptions.shuffled()
                    emit(TriviaGame(triviaOptions, correctOption))
                }
        }
    }
}


