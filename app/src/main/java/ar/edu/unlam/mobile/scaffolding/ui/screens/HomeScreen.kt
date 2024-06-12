package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffolding.ui.components.StartGameButton

@Composable
fun HomeScreen(startGameAction: () -> Unit, modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {
    val uiState: HomeUIState by viewModel.uiState.collectAsState()
    PantallaInicio(startGameAction = startGameAction)
}

@Composable
fun PantallaInicio(startGameAction: () -> Unit) {
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .wrapContentSize(),
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            StartGameButton(onClick = startGameAction)
            Text(
                "Pokemon Trivia",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun PreviewPantallaInicio() {
    PantallaInicio {
    }
}
