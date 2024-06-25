package ar.edu.unlam.mobile.scaffolding.domain.model

data class TriviaGame(
    val options: List<TriviaOption>,
    val correctOption: TriviaOption
)