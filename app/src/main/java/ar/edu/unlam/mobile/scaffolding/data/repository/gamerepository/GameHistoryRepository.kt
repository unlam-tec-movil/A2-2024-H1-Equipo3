package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository

import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.GameLocalSource
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.toGame
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.toGameDto
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.toGameEntity
import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameHistoryRepository @Inject constructor(private val gameLocalSource: GameLocalSource) :
    GameRepository {
    override suspend fun getGames(): Flow<List<Game>> {
        return gameLocalSource.getGames().mapList { it.toGame() }
    }

    override suspend fun saveGame(game: Game) {
        gameLocalSource.saveGame(game.toGameDto())
    }
}