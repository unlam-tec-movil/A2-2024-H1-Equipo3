package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.local.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model.GameEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface GameDao {

    @Query("SELECT * FROM game")
    fun getGame(): Flow<List<GameEntity>>
    @Upsert
    fun saveGame(game: GameEntity)

}