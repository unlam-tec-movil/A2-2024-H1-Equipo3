package ar.edu.unlam.mobile.scaffolding.ui.screens.gamehistory

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetGamesHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameHistoryViewModel @Inject constructor(private val getGamesHistory: GetGamesHistoryUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(GameHistoryUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        getGamesHistory()
    }
    private fun getGamesHistory() {
        viewModelScope.launch {
            _uiState.value = GameHistoryUiState(gameUiState = GameHistoryUi.Loading)
            getGamesHistory.getGamesHistory().collect { data ->
                _uiState.update { it.copy(gameUiState = GameHistoryUi.Success(data)) }
            }
        }
    }

}

data class GameHistoryUiState(val gameUiState: GameHistoryUi = GameHistoryUi.Loading)

@Immutable
sealed interface GameHistoryUi {
    data object Loading : GameHistoryUi
    data class Success(val data: List<Game>) : GameHistoryUi
    data class Error(val message: String) : GameHistoryUi
}