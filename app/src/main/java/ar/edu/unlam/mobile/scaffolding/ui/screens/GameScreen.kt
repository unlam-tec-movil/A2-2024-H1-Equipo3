package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.unlam.mobile.scaffolding.NavigationRoutes
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.PokemonRepositoryImpl
import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import ar.edu.unlam.mobile.scaffolding.ui.components.LoadingScreen
import ar.edu.unlam.mobile.scaffolding.ui.components.PokeOptions
import ar.edu.unlam.mobile.scaffolding.ui.components.PokemonImage
import ar.edu.unlam.mobile.scaffolding.ui.components.TriviaOptionUi
import ar.edu.unlam.mobile.scaffolding.ui.screens.gamehistory.ErrorScreen
import ar.edu.unlam.mobile.scaffolding.ui.theme.rojoPokeball

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val uiState: GameScreenUI by viewModel.uiState.collectAsState()

    when (val gameState = uiState.gameUiState) {
        is GameUiState.Loading -> {
            LoadingScreen()
        }

        is GameUiState.Success -> {
            GameScreenUI(
                modifier = modifier,
                pokemonList = gameState.gameData.options.map {
                    it.toUi()
                },
                correctPokemon = gameState.gameData.correctOption.option,
                lifes = gameState.lifes,
                score = gameState.score,
                selectedPoke = viewModel::onOptionSelected,
            )
            LaunchedEffect(key1 = gameState) {
                if (gameState.finishGame) {
                    navController.navigate("${NavigationRoutes.FinishGame.route.takeWhile { it != '/' }}/${gameState.score}")
                }
            }
        }

        is GameUiState.Error -> {
            ErrorScreen(modifier = modifier)
        }

    }
}

@Composable
fun GameScreenUI(
    modifier: Modifier,
    pokemonList: List<TriviaOptionUi>,
    correctPokemon: Pokemon,
    lifes: Int,
    score: Int,
    selectedPoke: (TriviaOptionUi) -> Unit
) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.game_background),
            contentDescription = "Imagen de fondo"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Row {
                repeat(lifes) {
                    Icon(
                        modifier = Modifier
                            .size(50.dp)
                            .padding(start = 10.dp, top = 10.dp),
                        painter = painterResource(id = R.drawable.vida),
                        contentDescription = "vida$lifes",
                        tint = Color.White
                    )
                }
            }

            PokemonImage(
                pokemon = correctPokemon,
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp)
                    .padding(top = 40.dp)
            )


            Spacer(modifier = Modifier.height(35.dp))
            PokeOptions(pokemonList, selectedPoke)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.puntaje_game, score),
                style = MaterialTheme.typography.titleLarge.copy(color = rojoPokeball, fontFamily = FontFamily(
                    Font(R.font.press_start_2p)
                )),
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
        }

    }
}

