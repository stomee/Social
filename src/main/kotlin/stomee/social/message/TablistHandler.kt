package stomee.social.message

import net.minestom.server.entity.Player
import net.minestom.server.event.player.PlayerSpawnEvent
import world.cepi.kstom.addEventCallback
import world.cepi.kstom.adventure.asMini

fun tablistHook(player: Player) {
    player.addEventCallback<PlayerSpawnEvent> {
        player.sendPlayerListHeader("<gradient:dark_purple:blue>stomee</gradient>".asMini())
    }
}