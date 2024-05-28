package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffolding.domain.services.Pokemon


@Composable
fun PokemonImage(pokemon: Pokemon, modifier: Modifier){
    Box(modifier = modifier) {
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = pokemon.imagen),
            contentDescription = pokemon.nombre)
    }
}
