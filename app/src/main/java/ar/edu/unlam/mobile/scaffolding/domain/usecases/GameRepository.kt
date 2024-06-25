package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    suspend fun getGames(): Flow<List<Game>>
    suspend fun saveGame(game: Game)
}