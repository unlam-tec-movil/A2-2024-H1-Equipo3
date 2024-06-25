package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository

import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.GameLocalSource
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.toGame
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.toGameDto
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.toGameEntity
import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameHistoryRepository @Inject constructor(private val gameLocalSource: GameLocalSource) :
    GameRepository {
    override suspend fun getGames(): Flow<List<Game>> {
        return gameLocalSource.getGames().mapList { it.toGame() }.flowOn(Dispatchers.IO)
    }

    override suspend fun saveGame(game: Game) {
        withContext(Dispatchers.IO) {
            gameLocalSource.saveGame(game.toGameDto())
        }
    }
}