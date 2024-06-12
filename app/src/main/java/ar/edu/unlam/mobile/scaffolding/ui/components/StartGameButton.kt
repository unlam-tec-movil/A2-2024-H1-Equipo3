package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.unlam.mobile.scaffolding.R

@Composable
fun StartGameButton(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.pokeball),
        contentDescription = "Start Game",
        Modifier.clickable { onClick() },
    )
}

@Preview
@Composable
fun PreviewStartGameButton() {
    StartGameButton {
    }
}
