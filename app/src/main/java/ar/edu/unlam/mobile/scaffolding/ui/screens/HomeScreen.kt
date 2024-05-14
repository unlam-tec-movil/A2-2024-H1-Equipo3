package ar.edu.unlam.mobile.scaffolding.ui.screens

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.MainScreen
import ar.edu.unlam.mobile.scaffolding.Usuario
import ar.edu.unlam.mobile.scaffolding.ui.components.BottomBar
import ar.edu.unlam.mobile.scaffolding.ui.components.Greeting
import ar.edu.unlam.mobile.scaffolding.ui.components.LoadingScreen
import ar.edu.unlam.mobile.scaffolding.ui.components.UserBar

@Preview
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: HomeViewModel = hiltViewModel()
) {
    // La información que obtenemos desde el view model la consumimos a través de un estado de
    // "tres vías": Loading, Success y Error. Esto nos permite mostrar un estado de carga,
    // un estado de éxito y un mensaje de error.
    val uiState: HomeUIState by viewModel.uiState.collectAsState()

    when (val helloState = uiState.helloMessageState) {
        is HelloMessageUIState.Loading -> {
            // Loading
            LoadingScreen()
        }

        is HelloMessageUIState.Success -> {
            PantallaInicio()
        }

        is HelloMessageUIState.Error -> {
            // Error
        }
    }
 }


@Composable
fun PantallaInicio(){
    val usuarioTest = Usuario()
    val controller = rememberNavController()
    Column(modifier = Modifier.fillMaxSize()) {
        UserBar(usuarioTest.nickname, usuarioTest.coins)
        Card() {
                Column {
                    Row {
                    //TODO 3 columnas con filas de 3 pokemones ya desbloqueados por el usuario
                    }
                }
        }
        BottomBar(controller = controller)
    }

}