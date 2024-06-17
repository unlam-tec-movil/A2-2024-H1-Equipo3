package ar.edu.unlam.mobile.scaffolding.ui.screens.gamehistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetGamesHistoryUseCase
import ar.edu.unlam.mobile.scaffolding.ui.screens.GameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class GameHistoryViewModel(private val getGamesHistory: GetGamesHistoryUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(GameHistoryUiState())
    val uiState get() = _uiState.asStateFlow()
    fun getGamesHistory() {
        viewModelScope.launch {
            _uiState.value = GameHistoryUiState(gameUiState = GameHistoryUi.Loading)
            getGamesHistory.getGamesHistory().collect { data ->
                _uiState.update { it.copy(gameUiState = GameHistoryUi.Success(data)) }
            }
        }
    }

}

data class GameHistoryUiState(val gameUiState: GameHistoryUi = GameHistoryUi.Loading)

sealed class GameHistoryUi {
    data object Loading : GameHistoryUi()
    data class Success(val data: List<Game>) : GameHistoryUi()
    data class Error(val message: String) : GameHistoryUi()
}