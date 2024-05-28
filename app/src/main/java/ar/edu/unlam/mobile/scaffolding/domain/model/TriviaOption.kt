package ar.edu.unlam.mobile.scaffolding.domain.model

import ar.edu.unlam.mobile.scaffolding.domain.services.Pokemon

data class TriviaOption(val option: Pokemon, val isCorrect: Boolean)