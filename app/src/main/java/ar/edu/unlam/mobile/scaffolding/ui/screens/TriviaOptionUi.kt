package ar.edu.unlam.mobile.scaffolding.ui.screens

import ar.edu.unlam.mobile.scaffolding.domain.services.Pokemon

data class TriviaOptionUi(
    val text: Pokemon,
    val isCorrect: Boolean,
    var answerState: AnswerState
)