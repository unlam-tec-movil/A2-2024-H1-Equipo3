package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import ar.edu.unlam.mobile.scaffolding.R
import ar.edu.unlam.mobile.scaffolding.ui.theme.rojoPokeball


@Preview
@Composable
fun BotonOpcion(pokemon : String = ""){

    //Hay que cambiarle el tamaño para que ocupe todo el largo de la pantalla
    //Y que tenga un padding, si es posible redondearlo mejor.

    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = rojoPokeball,
            contentColor = Color.White
        )) {
        Text(text = pokemon)
    }

}

