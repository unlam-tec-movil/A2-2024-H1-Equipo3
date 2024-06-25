package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.unlam.mobile.scaffolding.MainActivity
import ar.edu.unlam.mobile.scaffolding.NavigationRoutes
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.MenuButton
import ar.edu.unlam.mobile.scaffolding.ui.components.StartGameButton

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val uiState: HomeUIState by viewModel.uiState.collectAsState()
    val context = LocalContext.current as MainActivity
    PantallaInicio(modifier = modifier, startGameAction = {
        navController.navigate(NavigationRoutes.StartGame.route)
    },
        gameHistoryAction = {
            navController.navigate(NavigationRoutes.GameHistory.route)
        },
        exit = {
            context.finish()
        })
}

@Composable
fun PantallaInicio(
    modifier: Modifier = Modifier, startGameAction: () -> Unit,
    exit: () -> Unit,
    gameHistoryAction: () -> Unit
) {
    Box(
        modifier =
        modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.menu_bg),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_titl),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            Image(
                painter = painterResource(id = R.drawable.pokemon_png_free_download),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            Row(
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                MenuButton(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(100.dp),
                    text = stringResource(R.string.salir),
                    action = exit
                )
                MenuButton(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(150.dp),
                    text = stringResource(R.string.empezar),
                    action = startGameAction
                )
                MenuButton(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(100.dp),
                    text = stringResource(R.string.partidas),
                    action = gameHistoryAction
                )
            }

        }

    }
}

}
