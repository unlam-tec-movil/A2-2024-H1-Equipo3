package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {


}

sealed interface GameUIState {
    data class Success(val triviaOptions: List<TriviaOptions>) : GameUIState

    data object Loading : GameUIState

    data class Error(val message: String) : GameUIState
}