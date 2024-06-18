package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.model.Game

interface SaveGameUseCase {
    suspend fun saveGame(score:Int,user: String = "User1")
}