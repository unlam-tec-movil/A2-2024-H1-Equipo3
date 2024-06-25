package ar.edu.unlam.mobile.scaffolding.domain.services

import android.os.Build
import androidx.annotation.RequiresApi
import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameRepository
import ar.edu.unlam.mobile.scaffolding.domain.usecases.SaveGameUseCase
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import javax.inject.Inject

class SaveGameService @Inject constructor(private val gameRepository: GameRepository) :
    SaveGameUseCase {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun saveGame(score: Int, user: String) {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val formattedDate = LocalDate.now().format(formatter)
        gameRepository.saveGame(
            Game(
                user,
                score,
                formattedDate
            )
        )
    }
}