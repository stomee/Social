package stomee.social

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.adventure.audience.Audiences
import net.minestom.server.entity.Player
import net.minestom.server.event.player.PlayerDisconnectEvent
import net.minestom.server.event.player.PlayerSpawnEvent
import world.cepi.kstom.addEventCallback
import javax.swing.text.AbstractDocument

fun hook(player: Player) {
    player.addEventCallback<PlayerSpawnEvent> {
        Audiences.all().sendMessage(Component.text("${player.username} has joined the game!", NamedTextColor.BLUE))
    }

    player.addEventCallback<PlayerDisconnectEvent> {
        Audiences.all().sendMessage(Component.text("${player.username} has left the game!", NamedTextColor.AQUA))
    }
}