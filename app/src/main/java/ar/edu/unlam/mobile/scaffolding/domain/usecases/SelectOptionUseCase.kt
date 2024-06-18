package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaResult

interface SelectOptionUseCase {
    fun selectOption(optionSelected: TriviaOption, actualScore: Int, actualLife: Int): TriviaResult
}