package ar.edu.unlam.mobile.scaffolding.domain.model

data class TriviaResult(
    val correct: Boolean,
    val score: Int = 0,
    val lifes: Int = 3,
    val finishGame: Boolean = false
)