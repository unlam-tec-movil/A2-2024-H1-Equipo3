package ar.edu.unlam.mobile.scaffolding.ui.screens.gamehistory

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.domain.model.Game
import ar.edu.unlam.mobile.scaffolding.ui.components.LoadingScreen
import ar.edu.unlam.mobile.scaffolding.ui.theme.rojoPokeball

@Composable
fun GameHistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: GameHistoryViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    Box(modifier = modifier.fillMaxSize()) {
        when (val state = uiState.value.gameUiState) {
            is GameHistoryUi.Error -> ErrorScreen(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center),
                error = state.message
            )

            GameHistoryUi.Loading -> LoadingScreen()
            is GameHistoryUi.Success -> GameHistorySuccessScreen(games = state.data)
        }
    }
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    error: String = stringResource(R.string.uknown_error)
) {
    Text(
        text = error, modifier = modifier, color = Color.Red
    )

}


@Composable
fun GameHistorySuccessScreen(modifier: Modifier = Modifier, games: List<Game> = emptyList()) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(games) { game ->
            GameItem(
                modifier = Modifier,
                userName = game.userName,
                score = game.score,
                date = game.date
            )
        }
    }
}

@Composable
fun GameItem(
    modifier: Modifier = Modifier,
    userName: String,
    score: Int,
    date: String
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors().copy(containerColor = rojoPokeball)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 20.dp)
                    .fillMaxWidth()
                    .background(Color.DarkGray)

            ) {
                Column {
                    GameItemData(data = stringResource(R.string.nombre, userName))
                    GameItemData(data = stringResource(R.string.puntuacion, score))
                    GameItemData(data = stringResource(R.string.fecha, date))
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                BackgroundDots(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp), color = Color.Green
                )
                BackgroundDots(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp), color = Color.Red
                )
                BackgroundDots(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp), color = Color.Yellow
                )
            }
        }
    }
}

@Composable
fun GameItemData(modifier: Modifier = Modifier, data: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = data, style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White, fontFamily = FontFamily(
                    Font(R.font.press_start_2p)
                )
            )
        )
    }
}

@Composable
fun BackgroundDots(modifier: Modifier = Modifier, color: Color) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color = color, shape = CircleShape)
            .border(2.dp, Color.Black, CircleShape)
    )
}