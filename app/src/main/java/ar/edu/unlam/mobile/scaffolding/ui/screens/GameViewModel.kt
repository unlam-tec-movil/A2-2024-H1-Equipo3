package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaGame
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import ar.edu.unlam.mobile.scaffolding.ui.components.TriviaOptionUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

@HiltViewModel
class GameViewModel @Inject constructor(private val getOptionsUseCase: GetOptionsUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow(
        GameScreenUI(
            gameUiState = GameUiState.Loading
        )
    )

    val uiState = _uiState.asStateFlow()

    init {
        getTriviaOptions()
    }

    fun onOptionSelected(option: TriviaOptionUi) {
        val currentData = _uiState.value.gameUiState as GameUiState.Success
        val gameData = currentData.gameData
        // Todo lógica después de elegir
        if (gameData.correctOption.option.nombre == option.pokemon.nombre) {
            option.answerState = AnswerState.CORRECT
        } else {
            option.answerState = AnswerState.INCORRECT
        }
    }

    fun getTriviaOptions() {
        viewModelScope.launch {
            getOptionsUseCase.getNewGame()
                .catch {
                    _uiState.value = _uiState.value.copy(
                        gameUiState = GameUiState.Error(
                            message = it.localizedMessage ?: "Error"
                        )
                    )
                }
                .collect {
                    _uiState.value = _uiState.value.copy(
                        gameUiState = GameUiState.Success(
                            gameData = it,
                            isOptionSelected = false
                        )
                    )
                }
        }
    }
}

//fun onOptionSelected(option: Int) {
//    val currentState = _uiState.value as GameUiState.Success
//    val selectedOption = currentState.triviaOptions[option]
//    when (selectedOption.isCorrect) {
//        true -> currentState.triviaOptions[option].answerState = AnswerState.CORRECT
//        false -> currentState.triviaOptions[option].answerState = AnswerState.INCORRECT
//    }
//    _uiState.update { currentState.copy(isOptionSelected = true) }
//}
//
//fun onNextQuestion() {
//    _uiState.update { GameUiState.Loading }
//    getTriviaOptions()
//}

fun TriviaOption.toUi() = TriviaOptionUi(
    pokemon = this.option,
    isCorrect = this.isCorrect,
    answerState = AnswerState.NOT_ANSWERED
)

data class GameScreenUI(
    val gameUiState: GameUiState
)

@Immutable
sealed interface GameUiState {
    data class Success(
        val gameData: TriviaGame,
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

