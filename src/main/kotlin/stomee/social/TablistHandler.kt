package stomee.social

import net.kyori.adventure.text.Component
import net.minestom.server.entity.Player
import net.minestom.server.event.player.PlayerSpawnEvent
import world.cepi.kstom.Manager
import world.cepi.kstom.addEventCallback
import world.cepi.kstom.adventure.asMini

fun tablistHook(player: Player) {
    player.addEventCallback<PlayerSpawnEvent> {

        val playerCount = Manager.connection.onlinePlayers.size

        player.sendPlayerListHeaderAndFooter(
            Component.newline()
                .append("<gradient:${StomeeColors.purple}:${StomeeColors.blue}>    stomee anarchy    </gradient>".asMini())
                .append(Component.newline()),
            Component.newline()
                .append(
                    Component.text(
                        "$playerCount player${if (playerCount == 1) "" else "s"} online.",
                        StomeeColors.middleColor.lighten(.2)
                    )
                )
                .append(Component.newline())
        )
    }
}