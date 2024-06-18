package ar.edu.unlam.mobile.scaffolding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ar.edu.unlam.mobile.scaffolding.ui.components.TopBar
import ar.edu.unlam.mobile.scaffolding.ui.screens.FinishScreen
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
                Scaffold { paddingValue ->
                    NavHost(
                        navController = controller,
                        startDestination = NavigationRoutes.Menu.route
                    ) {
                        composable(NavigationRoutes.Menu.route) {
                            HomeScreen(
                                modifier = Modifier.padding(paddingValue),
                                navController = controller
                            )
                        }
                        composable(NavigationRoutes.StartGame.route) {
                            GameScreen(
                                modifier = Modifier.padding(paddingValue),
                                navController = controller
                            )
                        }
                        composable(NavigationRoutes.GameHistory.route) {
                            GameHistoryScreen(modifier = Modifier.padding(paddingValue))
                        }
                        composable(route = NavigationRoutes.FinishGame.route,
                            arguments = listOf(navArgument("game_score") { type = NavType.IntType })) { backentry ->
                            val score = rememberSaveable {
                                backentry.arguments?.getInt("game_score")?: 0
                            }
                            FinishScreen(
                                modifier = Modifier.padding(paddingValue),
                                score = score,
                                navController = controller
                            )
                        }
                    }
                }
            }
        }
    }
}


