package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local

import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.GameDto
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.GameEntity
import kotlinx.coroutines.flow.Flow

interface GameLocalSource {

    suspend fun getGames(): Flow<List<GameDto>>

    suspend fun saveGame(game: GameDto)
}