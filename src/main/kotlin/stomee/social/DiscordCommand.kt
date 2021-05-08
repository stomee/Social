package stomee.social

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.format.NamedTextColor
import stomee.social.DiscordCommand.discordURL
import world.cepi.kstom.command.SimpleKommand

object DiscordCommand : SimpleKommand("discord", process = { sender, _, _ ->
    sender.sendMessage(
        Component.text("Discord: ", NamedTextColor.DARK_PURPLE)
            .append(Component.text(discordURL, NamedTextColor.WHITE)
                .clickEvent(ClickEvent.openUrl(discordURL))
                .hoverEvent(HoverEvent.showText(Component.text("Click here to join our discord!", NamedTextColor.BLUE)))
            )
    )

    true
}) {

    const val discordURL = "https://discord.gg/vDkhB5hA4m"

}
