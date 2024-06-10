package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.components.BotonOpcion
import ar.edu.unlam.mobile.scaffolding.ui.components.LoadingScreen

@Preview
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState : HomeUIState by viewModel.uiState.collectAsState()
    
    when(val homeState = uiState){
        is HomeUIState.Loading -> {
            LoadingScreen()
        }
        
        is HomeUIState.Success -> {
            PantallaInicio(homeState.options)
        }
        
        is HomeUIState.Error -> {
            //TODO Manejar flujo de error
        }

    }


 }

@Composable
fun PantallaInicio(options: List<String>) {

Column(modifier = Modifier
    .fillMaxSize()
    .background(color = Color.Gray)) {


    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)){
        Row (Modifier.fillMaxSize()){
            //TODO Colocar dentro de boton
            Icon(painter = painterResource(id = R.drawable.ic_scoreboard), contentDescription = "Historial de top 10 score")
        //Otro icon que vaya en la parte superior de la pantalla
        }

    }
    //TODO Acomodar botones y agregar el icono de la app en el centro como presentacion
        Spacer(modifier = Modifier.size(300.dp))
        BotonOpcion(options[0])

        Spacer(modifier = Modifier.size(150.dp))
        BotonOpcion(options[1])
}

}

@Preview
@Composable
fun PreviewPantallaInicio(){
    
    val opciones = listOf("Jugar", "Salir")
    
    PantallaInicio(options = opciones)
    
}