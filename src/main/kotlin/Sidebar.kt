import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.ArrowRight
import extensions.Buttons.navBtn
import theme.Colors

@Preview
@Composable
fun sidebar(onItemClick: (Int) -> Unit, color: Int) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(200.dp)
            .padding(vertical = 16.dp)
    ) {
        Button(onClick = { onItemClick(0) }) {
            Text("Home")
        }
        Button(onClick = { onItemClick(1) }) {
            Text("Settings")
        }
        Button(onClick = { onItemClick(2) }) {
            Text("Account")
        }
    }
}

enum class NavPos {
    Left, Center, Right
}

@Preview
@Composable
fun navbar(onItemClick: (Int) -> Unit) {

    var navPos by remember { mutableStateOf(NavPos.Left) }
    var alignment = when (navPos) {
        NavPos.Left -> Alignment.TopStart
        NavPos.Center -> Alignment.TopCenter
        NavPos.Right -> Alignment.TopEnd
    }

    val btn = 3
    val btnPad = 16.dp
    val btnWidth = 48.dp
    val navWidth = (btnWidth + btnPad) * btn

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = alignment
    ) {
        Box(
            modifier = Modifier
                .width(240.dp)
                .padding(16.dp)
                .background(Colors.navbar, shape = RoundedCornerShape(18))
        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .background(Colors.navbar),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                navBtn("instances", onClick = { onItemClick(0) })
                Spacer(modifier = Modifier.width(8.dp))
                navBtn("settings", onClick = { onItemClick(1) })
                Spacer(modifier = Modifier.width(8.dp))
                navBtn("account", onClick = { onItemClick(2) })
                Spacer(modifier = Modifier.width(8.dp))
                Text(" || ", color = Color.White)
                Spacer(modifier = Modifier.width(4.dp))
                IconButton(
                    onClick = {
                        navPos = when (navPos) {
                            NavPos.Left -> NavPos.Center
                            NavPos.Center -> NavPos.Right
                            NavPos.Right -> NavPos.Left
                        }
                    },
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .background(Colors.btn, shape = RoundedCornerShape(24))
                        .padding(4.dp),
                ) {
                    Icon(
                        imageVector = when (navPos) {
                            NavPos.Left -> FontAwesomeIcons.Solid.ArrowRight
                            NavPos.Center -> FontAwesomeIcons.Solid.ArrowRight
                            NavPos.Right -> FontAwesomeIcons.Solid.ArrowLeft
                        },
                        contentDescription = null,
                        tint = Colors.label
                    )
                }
            }
        }
    }
}