package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ar.edu.unlam.mobile.scaffolding.domain.model.Pokemon
import coil.compose.AsyncImage


@Composable
fun PokemonImage(pokemon: Pokemon, modifier: Modifier){
    Box(modifier = modifier) {
        AsyncImage(modifier = Modifier.fillMaxSize(),
            model = pokemon.image,
            contentDescription = pokemon.name)
    }
}
