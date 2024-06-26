package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffolding.ui.components.LoadingScreen

@Preview
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: GameViewModel = hiltViewModel()
) {
    // La información que obtenemos desde el view model la consumimos a través de un estado de
    // "tres vías": Loading, Success y Error. Esto nos permite mostrar un estado de carga,
    // un estado de éxito y un mensaje de error.
    val uiState: GameUiState by viewModel.uiState.collectAsState()



 }

@Preview
@Composable
fun PantallaInicio(){


}