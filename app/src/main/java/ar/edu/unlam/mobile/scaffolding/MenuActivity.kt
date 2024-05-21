package ar.edu.unlam.mobile.scaffolding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffolding.ui.components.StartButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            StartButton("Iniciar")
        }

    }
}

@Composable
fun MenuScreen(){
    val controller = rememberNavController()


}