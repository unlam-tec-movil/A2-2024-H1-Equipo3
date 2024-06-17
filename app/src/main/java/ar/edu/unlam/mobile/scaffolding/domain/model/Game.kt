package ar.edu.unlam.mobile.scaffolding.domain.model

data class Game(
    val userName: String,
    val correctQuestions: Int,
    val score: Int,
    val date: String
)