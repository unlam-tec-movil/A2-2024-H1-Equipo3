package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaGame
import ar.edu.unlam.mobile.scaffolding.domain.model.TriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.model.toTriviaOption
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetOptionsUseCase
import ar.edu.unlam.mobile.scaffolding.domain.usecases.SaveGameUseCase
import ar.edu.unlam.mobile.scaffolding.domain.usecases.SelectOptionUseCase
import ar.edu.unlam.mobile.scaffolding.ui.components.TriviaOptionUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getOptionsUseCase: GetOptionsUseCase,
    private val selectOptionUseCase: SelectOptionUseCase,
    private val saveGameUseCase: SaveGameUseCase
) :
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
        val triviaResult =
            selectOptionUseCase.selectOption(
                option.pokemon.toTriviaOption(),
                currentData.score,
                currentData.lifes
            )
        if (triviaResult.correct) {
            option.answerState = AnswerState.CORRECT
            _uiState.update { state ->
                state.copy(gameUiState = currentData.copy(score = triviaResult.score))
            }
            getTriviaOptions()
        } else if (!triviaResult.finishGame) {
            option.answerState = AnswerState.INCORRECT
            _uiState.update { state -> state.copy(gameUiState = currentData.copy(lifes = triviaResult.lifes)) }
            getTriviaOptions()
        } else {
            viewModelScope.launch {
                saveGameUseCase.saveGame(triviaResult.score)
                _uiState.update { state -> state.copy(gameUiState = currentData.copy(finishGame = true)) }
            }
        }
    }

    private fun getTriviaOptions() {
        val currentData = _uiState.value.gameUiState as GameUiState.Success
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
                    _uiState.update { state ->
                        state.copy(
                            gameUiState = currentData.copy(
                                gameData = it,
                                isOptionSelected = false
                            )
                        )
                    }
                }
        }
    }
}

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
        val score: Int = 0,
        val lifes: Int = 3,
        val isOptionSelected: Boolean = false,
        val finishGame: Boolean = false
    ) : GameUiState

    data object Loading : GameUiState
    data class Error(val message: String) : GameUiState

}

enum class AnswerState {
    NOT_ANSWERED,
    CORRECT,
    INCORRECT
}

