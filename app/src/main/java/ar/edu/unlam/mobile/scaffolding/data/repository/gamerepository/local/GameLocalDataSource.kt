package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local

import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.db.GameDao
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.mapList
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.GameDto
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.toGameDto
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.toGameEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameLocalDataSource @Inject constructor(private val gameDao: GameDao): GameLocalSource {
    override suspend fun getGames(): Flow<List<GameDto>> {
        return gameDao.getGame().mapList { it.toGameDto() }
    }

    override suspend fun saveGame(game: GameDto) {
        gameDao.saveGame(game.toGameEntity())
    }
}