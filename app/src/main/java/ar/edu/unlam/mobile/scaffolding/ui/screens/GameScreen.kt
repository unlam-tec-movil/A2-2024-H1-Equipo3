package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.data.repository.pokemonrepository.PokemonTestRepository
import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import ar.edu.unlam.mobile.scaffolding.ui.components.LoadingScreen
import ar.edu.unlam.mobile.scaffolding.ui.components.PokeOptions
import ar.edu.unlam.mobile.scaffolding.ui.components.PokemonImage
import ar.edu.unlam.mobile.scaffolding.ui.components.TriviaOptionUi

@Composable
fun GameScreen(
    controller: NavController,
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: GameViewModel = hiltViewModel()
) {
    val uiState: GameScreenUI by viewModel.uiState.collectAsState()

    when (val gameState = uiState.gameUiState) {
        is GameUiState.Loading -> {
            // Loading
            LoadingScreen()
        }

        is GameUiState.Success -> {
            GameScreenUI(
                pokemonList = gameState.gameData.options.map {
                    it.toUi()
                },
                pokemonCorrecto = gameState.gameData.correctOption.option,
                selectedPoke = viewModel::onOptionSelected,
            )
        }

        is GameUiState.Error -> {

        }
    }
}

//Ejemplo hardcodeado para poder previsualizar la pantalla
@Preview
@Composable
fun PreviewGameScreen() {
    val charmander = TriviaOptionUi(PokemonTestRepository.charmander, isCorrect = true, answerState = AnswerState.NOT_ANSWERED)
    val bulbasaur = TriviaOptionUi(PokemonTestRepository.bulbasaur, isCorrect = false, answerState = AnswerState.NOT_ANSWERED)
    val squirtle = TriviaOptionUi(PokemonTestRepository.squirtle, isCorrect = false, answerState = AnswerState.NOT_ANSWERED)
    val pikachu = TriviaOptionUi(PokemonTestRepository.pikachu, isCorrect = false, answerState = AnswerState.NOT_ANSWERED)

    val listaPokemon = listOf(
        charmander,
        bulbasaur,
        squirtle,
        pikachu
    ).shuffled()
    val pokemonCorrecto = PokemonTestRepository.charmander

    GameScreenUI(pokemonList = listaPokemon, pokemonCorrecto) {

    }
}

@Composable
fun GameScreenUI(pokemonList: List<TriviaOptionUi>, pokemonCorrecto: Pokemon, selectedPoke: (TriviaOptionUi) -> Unit) {
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
            var numeroVida: Int = 1
            repeat(3) {
                Icon(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 10.dp, top = 10.dp),
                    painter = painterResource(id = R.drawable.vida),
                    contentDescription = "vida$numeroVida",
                    tint = Color.White
                )
                numeroVida++
            }
        }

        PokemonImage(
            pokemon = pokemonCorrecto,
            Modifier
                .align(Alignment.CenterHorizontally)
                .size(300.dp)
                .padding(top = 40.dp)
        )


        Spacer(modifier = Modifier.height(35.dp))
        PokeOptions(pokemonList, selectedPoke)

    }
}

