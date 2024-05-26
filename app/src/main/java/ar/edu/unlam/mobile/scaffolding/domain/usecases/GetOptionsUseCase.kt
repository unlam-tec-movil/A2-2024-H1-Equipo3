package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption

interface GetOptionsUseCase {
     fun getOptions(): List<TriviaOption>
}