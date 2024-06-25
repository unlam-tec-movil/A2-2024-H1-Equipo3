package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import ar.edu.unlam.mobile.scaffolding.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar() {
    TopAppBar(title = { /*TODO*/ }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_scoreboard),
                contentDescription = "Historial de top 10 score"
            )
        }
    })
}