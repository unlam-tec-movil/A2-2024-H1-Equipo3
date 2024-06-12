package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import ar.edu.unlam.mobile.scaffolding.ui.screens.AnswerState

data class TriviaOptionUi(
    val pokemon: Pokemon,
    val isCorrect: Boolean,
    var answerState: AnswerState
)

@Composable
fun PokeOptions(pokemonList: List<TriviaOptionUi>, onClick: (pokemonId: TriviaOptionUi) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        pokemonList.forEach {
            BotonOpcion(it.pokemon.nombre, onClick = {
                onClick(it)
            })
        }
    }
}