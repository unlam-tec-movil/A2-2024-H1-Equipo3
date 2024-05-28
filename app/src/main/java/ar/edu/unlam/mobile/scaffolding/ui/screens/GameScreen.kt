package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import ar.edu.unlam.mobile.scaffolding.ui.components.BotonOpcion
import ar.edu.unlam.mobile.scaffolding.ui.components.LoadingScreen
import ar.edu.unlam.mobile.scaffolding.ui.components.PokemonImage
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.data.repository.PokemonTestRepository
import ar.edu.unlam.mobile.scaffolding.domain.services.Pokemon

@Composable
fun GameScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: GameViewModel = hiltViewModel()) {

    val uiState: GameUiState by viewModel.uiState.collectAsState()

    when (val gameState = uiState) {
        is GameUiState.Loading -> {
            // Loading
            LoadingScreen()
        }

        is GameUiState.Success -> {
            viewModel.searchCorrectPokemon(gameState.triviaOptions)
                ?.let { GameScreen(gameState.triviaOptions, it) }
        }

        is GameUiState.Error -> {
            // Error
        }
    }

}

@Composable
fun GameScreen(pokemonList: List<TriviaOptionUi>, pokemonCorrecto: Pokemon){

//TODO se debe trabajar en la logica del juego

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.game_background),
            contentDescription = "Imagen de fondo"
        )
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Row {
            var numeroVida:Int = 1
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

            PokemonImage(pokemon = pokemonCorrecto,
            Modifier
                .align(Alignment.CenterHorizontally)
                .size(300.dp)
                .padding(top = 40.dp)) }

        Spacer(modifier = Modifier.padding(35.dp))

            for (i in pokemonList) {
            Spacer(modifier = Modifier.padding(16.dp))
            BotonOpcion(i.pokemon.nombre)
        }
    }
