package stomee.social

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.format.NamedTextColor
import world.cepi.kstom.command.SimpleKommand

object DiscordCommand : SimpleKommand("discord", process = { sender, _, _ ->
    sender.sendMessage(
        Component.text("Discord: ", NamedTextColor.DARK_PURPLE)
            .append(Component.text("https://discord.gg/vDkhB5hA4m", NamedTextColor.WHITE)
                .clickEvent(ClickEvent.openUrl("https://discord.gg/vDkhB5hA4m"))
                .hoverEvent(HoverEvent.showText(Component.text("Click here to join our discord!", NamedTextColor.BLUE)))
            )
    )

    true
})
