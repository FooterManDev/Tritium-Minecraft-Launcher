package theme

import androidx.compose.ui.graphics.Color
import constants.Constants.HOME
import constants.Constants.ansiGreen
import constants.Constants.ansiRed
import constants.Constants.themeDir
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File
import java.nio.file.Files

@Serializable
data class ThemeColorsData(val navbar:String, val btn:String, val background:String, val label:String)

val selectedTheme = "default"

object Colors {
    private val themeColors: ThemeColorsData = loadTheme("$HOME/.tritium/${selectedTheme}.json")

    val navbar: Color get() = parseColorValue(themeColors.navbar)
    val btn: Color get() = parseColorValue(themeColors.btn)
    val background: Color get() = parseColorValue(themeColors.background)
    val label: Color get() = parseColorValue(themeColors.label)
}

fun parseColorValue(colStr:String): Color {
    if(colStr.length != 8) {
        throw IllegalArgumentException("Color string must be 8 characters long! Expecting RRGGBBAA. {$colStr}")
    }
    val colorInt = colStr.toULong(16).toInt()
    return Color(colorInt)
}

fun loadTheme(themeFile:String): ThemeColorsData {
    val json = File(themeFile).readText()
    return Json.decodeFromString(ThemeColorsData.serializer(), json)
}

fun displayThemes() {
    if(Files.exists(themeDir)) {
        val themes = File(themeDir.toString()).listFiles {_, name ->
            name.endsWith(".json")
        }

        if(!themes.isNullOrEmpty()) {
            println("Themes loaded:$ansiRed [")
            themes.forEach { file ->
                println("    " + ansiGreen + file.name)
            }
            println("$ansiRed]")
        }
    } else {
        println("Themes folder doesn't exist!")
    }
}