//import settings.settingsStartup
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import discord.RPC.runRPC
import discord.RPC.stopRPC
import pages.Pages
import pages.account
import pages.instances
import pages.settings
import theme.Colors
import theme.displayThemes

@Preview
@Composable
fun mainContent(content: @Composable () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Colors.background)) {
        content()
    }
}

fun main() = application {
    var currentPage by remember { mutableStateOf(Pages.Instances)}
    displayThemes()

    runRPC()
    Window(onCloseRequest = {
        stopRPC()
        exitApplication()
    }, title = "Tritium") {
        Column(modifier = Modifier.fillMaxSize()) {
            mainContent { navbar { index ->
                currentPage = Pages.entries.toTypedArray()[index]
            }
                when (currentPage) {
                    Pages.Instances -> instances()
                    Pages.Settings -> settings()
                    Pages.Account -> account()

                }
            }
        }
    }
}
