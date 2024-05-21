package pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
//import settings.jsonSetting

enum class Pages {
    Instances,
    Settings,
    Account
}

@Composable
fun instances() {
    Text(text = "Instances", modifier = Modifier.padding(200.dp), color = Color.White)
}

@Composable
fun settings() {
    Text(text = "Settings", modifier = Modifier.padding(50.dp), color = Color.White)
}

@Composable
fun account() {
    Text(text = "Account", modifier = Modifier.padding(200.dp), color = Color.White)
}