package discord

import club.minnced.discord.rpc.*
import constants.Constants.ansiBlue
import constants.Constants.ansiReset

object RPC {

    private val lib: DiscordRPC = DiscordRPC.INSTANCE
    private val handlers = DiscordEventHandlers()
    private var thread: Thread? = null
    private val presence = DiscordRichPresence()

    fun runRPC() {
        println("$ansiBlue~Discord~$ansiReset Initializing Rich Presence...")
        lib.Discord_Initialize("1241924358608388248", handlers, true, null)

        presence.startTimestamp = System.currentTimeMillis() / 1000
        presence.details = "App is really not finished yet..."
        presence.state = "There's no proper image for this yet."
        presence.largeImageKey = "fm16-dev"
        lib.Discord_UpdatePresence(presence)

        thread = Thread {
            try {
            while (!Thread.currentThread().isInterrupted) {
                lib.Discord_RunCallbacks()
                Thread.sleep(2000)
            }
                } catch (e: InterruptedException) {
                    lib.Discord_Shutdown()
                }
            }
        thread?.start()
    }

    fun stopRPC() {
        thread?.interrupt()
        println("$ansiBlue~Discord~$ansiReset Rich Presence stopped!")
    }
}