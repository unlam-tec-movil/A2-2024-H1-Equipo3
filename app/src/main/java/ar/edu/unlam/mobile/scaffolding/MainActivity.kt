package ar.edu.unlam.mobile.scaffolding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.ui.components.TopBar
import ar.edu.unlam.mobile.scaffolding.ui.screens.GameScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.HomeScreen
import ar.edu.unlam.mobile.scaffolding.ui.screens.gamehistory.GameHistoryScreen
import ar.edu.unlam.mobile.scaffolding.ui.theme.ScaffoldingV2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val controller = rememberNavController()
            ScaffoldingV2Theme {
                Scaffold(topBar = { TopBar() }) { paddingValue ->
                    NavHost(navController = controller, startDestination = "home") {
                        composable(NavigationRoutes.Menu.route) {
                            HomeScreen(
                                startGameAction = {
                                    controller.navigate("game")
                                }, modifier = Modifier.padding(paddingValue)
                            )
                        }
                        composable(NavigationRoutes.StartGame.route) {
                            GameScreen(controller)
                        }
                        composable(NavigationRoutes.GameHistory.route) {
                            GameHistoryScreen()
                        }
                    }
                }
            }
        }
    }
}


