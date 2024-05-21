package constants

import java.io.File
import java.nio.file.Path

@Suppress("ConstPropertyName")
object Constants {
    /* Env Vars */
    val HOME: String = System.getProperty("user.home")

    /* Paths */
    val themeDir: Path = File("$HOME/.tritium").toPath()

    /* Ansi */
    const val ansiRed = "\u001B[31m"
    const val ansiGreen = "\u001B[32m"
    const val ansiBlue = "\u001B[34m"
    const val ansiReset = "\u001B[0m"
}