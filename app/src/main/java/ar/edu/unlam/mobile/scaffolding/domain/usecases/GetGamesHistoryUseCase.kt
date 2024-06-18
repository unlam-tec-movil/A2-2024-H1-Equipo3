package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GetGamesHistoryUseCase {
    suspend fun getGamesHistory(): Flow<List<Game>>

}