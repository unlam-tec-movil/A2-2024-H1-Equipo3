package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaGame
import kotlinx.coroutines.flow.Flow

interface GetOptionsUseCase {
    fun getNewGame(): Flow<TriviaGame>
}