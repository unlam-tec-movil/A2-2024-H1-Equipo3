package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "game")
data class GameEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userName: String,
    val score: Int,
    val date: String
)