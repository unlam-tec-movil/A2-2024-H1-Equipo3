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
                        composable("home") {
                            HomeScreen(
                                startGameAction = {
                                    controller.navigate("game")
                                }, modifier = Modifier.padding(paddingValue)
                            )
                        }
                        composable("game") {
                            GameScreen(controller)
                        }
                    }
                }
            }
        }
    }
}

// ***********************************************************
// Como nuestra navegacion va a ser simple, no utilizaremos el navController por recomendacion del profesor
// Aun asi dejo comentado lo que estaba como ejemplo
// ***********************************************************

// Controller es el elemento que nos permite navegar entre pantallas. Tiene las acciones
// para navegar como naviegate y también la información de en dónde se "encuentra" el usuario
// a través del back stack
// val controller = rememberNavController()
// Scaffold(
// bottomBar = { BottomBar(controller = controller) },
// floatingActionButton = {
//  IconButton(onClick = { controller.navigate("home") }) {
//      Icon(Icons.Filled.Home, contentDescription = "Home")
//  }
// },
// ) { paddingValue ->
// NavHost es el componente que funciona como contenedor de los otros componentes que
// podrán ser destinos de navegación.
//   NavHost(navController = controller, startDestination = "home") {
// composable es el componente que se usa para definir un destino de navegación.
// Por parámetro recibe la ruta que se utilizará para navegar a dicho destino.
//      composable("home") {
// Home es el componente en sí que es el destino de navegación.
//          HomeScreen(modifier = Modifier.padding(paddingValue))
//      }
//  }
// }
