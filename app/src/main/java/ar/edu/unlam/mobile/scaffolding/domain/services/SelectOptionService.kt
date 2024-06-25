package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaResult
import ar.edu.unlam.mobile.scaffolding.domain.usecases.SelectOptionUseCase
import javax.inject.Inject

class SelectOptionService @Inject constructor(): SelectOptionUseCase {
    companion object{
        private const val IncrementScore = 3

    }
    override fun selectOption(optionSelected: TriviaOption, actualScore: Int,actualLife: Int): TriviaResult {
        return if(optionSelected.isCorrect) {
            TriviaResult(true, actualScore + IncrementScore)
        }else{
            if(actualLife > 1){
                TriviaResult(false, actualScore, actualLife - 1)
            }else{
                TriviaResult(false, actualScore, 0, true)
            }
        }
    }

}