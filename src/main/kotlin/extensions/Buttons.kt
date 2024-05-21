package extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.regular.ListAlt
import compose.icons.fontawesomeicons.solid.Cogs
import compose.icons.fontawesomeicons.solid.Users
import theme.Colors

@Suppress("name_shadowing")
object Buttons {

    @Composable
    fun navBtn(icon: String, onClick: () -> Unit) {
        val icon = when (icon) {
            "instances" -> FontAwesomeIcons.Regular.ListAlt
            "settings" -> FontAwesomeIcons.Solid.Cogs
            "account" -> FontAwesomeIcons.Solid.Users
            else -> Icons.Outlined.Warning
        }
        IconButton(
            onClick = { onClick() },
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
                .background(Colors.btn, shape = RoundedCornerShape(24))
                .padding(4.dp),
        ) {
            Icon(icon, contentDescription = null, modifier = Modifier
                .size(32.dp),
                tint = Colors.label
            )
        }
    }
}