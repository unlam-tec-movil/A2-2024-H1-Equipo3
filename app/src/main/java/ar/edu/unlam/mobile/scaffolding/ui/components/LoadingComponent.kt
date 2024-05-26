package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import android.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
@Composable
fun LoadingScreen(){
    var loadingText = "Cargando"
    CircularProgressIndicator()
    Text (text = loadingText)
}