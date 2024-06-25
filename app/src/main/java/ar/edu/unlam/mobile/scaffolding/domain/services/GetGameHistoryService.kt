package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetGamesHistoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetGameHistoryService @Inject constructor(private val gameRepository: GameRepository) :
    GetGamesHistoryUseCase {
    override suspend fun getGamesHistory(): Flow<List<Game>> {
        return gameRepository.getGames()
    }
}