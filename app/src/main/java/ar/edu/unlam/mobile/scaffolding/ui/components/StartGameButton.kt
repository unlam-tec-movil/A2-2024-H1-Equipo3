package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffolding.R

@Composable
fun StartGameButton(modifier: Modifier = Modifier,onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.pokeball),
        contentDescription = "Start Game",
        modifier.clickable { onClick() },
    )
}

@Preview
@Composable
fun PreviewStartGameButton() {
    StartGameButton {
    }
}
