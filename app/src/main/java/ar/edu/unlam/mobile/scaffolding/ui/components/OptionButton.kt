package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile.scaffolding.ui.theme.optionButtonColor


@Preview
@Composable
fun BotonOpcion(pokemon : String = ""){

    Button( modifier = Modifier
        .fillMaxWidth()
        .border(width = 3.dp, color = Color.Black, shape = RoundedCornerShape(20.dp)),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = optionButtonColor,
            contentColor = Color.White,
        )) {
        Text(modifier = Modifier.padding(top = 5.dp),
            text = pokemon,
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 25.sp)
        )
    }

}

