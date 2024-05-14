package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun UserBar(userName:String = "Nickname", userCoins:Int = 0){

    Row (modifier = Modifier.fillMaxWidth()){
        Box(modifier = Modifier.padding(15.dp)) {
            UserProfilePicture()
            Text(text = userName, Modifier.padding(start = 30.dp, top = 5.dp))
            Text(text = "Monedas:", Modifier.padding(start = 160.dp, top = 5.dp))
            Text(text = userCoins.toString(), Modifier.padding(start = 240.dp, top = 5.dp))
        }
        }


}