package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(private val getOptionsUseCase: GetOptionsUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow<GameUiState>(GameUiState.Loading)
    val uiState = _uiState.asStateFlow()
    init {
        getTriviaOptions()
    }

    fun getTriviaOptions() {
        viewModelScope.launch {
            try {
                val options = getOptionsUseCase.getOptions()
                _uiState.update { GameUiState.Success(options.map { it.toUi() }) }
            } catch (e: Exception) {
                _uiState.value = GameUiState.Error(e.message ?: "An error occurred")
            }
        }
    }

    fun onOptionSelected(option: Int) {
        val currentState = _uiState.value as GameUiState.Success
        val selectedOption = currentState.triviaOptions[option]
        when (selectedOption.isCorrect) {
            true -> currentState.triviaOptions[option].answerState = AnswerState.CORRECT
            false -> currentState.triviaOptions[option].answerState = AnswerState.INCORRECT
        }
        _uiState.update { currentState.copy(isOptionSelected = true) }
    }

    fun onNextQuestion() {
        _uiState.update { GameUiState.Loading }
        getTriviaOptions()
    }
    private fun TriviaOption.toUi() = TriviaOptionUi(
        text = this.option,
        isCorrect = this.isCorrect,
        answerState = AnswerState.NOT_ANSWERED
    )


}

sealed interface GameUiState {
    data class Success(
        val triviaOptions: List<TriviaOptionUi>,
        val isOptionSelected: Boolean = false
    ) : GameUiState

    data object Loading : GameUiState

    data class Error(val message: String) : GameUiState

}

enum class AnswerState {
    NOT_ANSWERED,
    CORRECT,
    INCORRECT
}

