package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Immutable
sealed interface HomeUIState {
    data class Success(val options: List<String>) : HomeUIState

    data object Loading : HomeUIState

    data class Error(val message: String) : HomeUIState
}

@HiltViewModel
class HomeViewModel
    @Inject
    constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState = _uiState.asStateFlow()

        init {
            createView()
        }

    private fun createView(){
        viewModelScope.launch {
            _uiState.value = HomeUIState.Loading
            //Simula una pantalla de carga
            delay(2000)

            try {
                val listaOpciones = listOf("Jugar", "Salir")
                _uiState.value = HomeUIState.Success(listaOpciones)
            } catch (e:Exception){
                _uiState.value = HomeUIState.Error("Ups... Ocurrio un error")
            }

        }
    }

    }
