package ar.edu.unlam.mobile.scaffolding.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.unlam.mobile.scaffolding.R

@Composable
fun UserProfilePicture() {
    Image(painter = painterResource(id = R.drawable.ic_user_default), contentDescription = "UserPic Default")
}






