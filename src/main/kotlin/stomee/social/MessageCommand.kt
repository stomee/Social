package stomee.social

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.arguments.ArgumentType
import net.minestom.server.entity.Player
import world.cepi.kstom.command.addSyntax

object MessageCommand : Command("msg", "tell", "whisper", "message") {

    init {

        val playerArg = ArgumentType.Entity("target").onlyPlayers(true).singleEntity(true)
        val messageArg = ArgumentType.StringArray("message")

        addSyntax(playerArg, messageArg) { sender, args ->

            // Serialize the name, "Console" if the sender is a console
            val senderName = if (sender is Player) {
                PlainComponentSerializer.plain().serialize(sender.name)
            } else {
                "Console"
            }

            // Grab the target
            val target = args.get(playerArg).find(sender)[0] as Player

            // Pre-build the message
            val builtMessage = Component.text("[$senderName -> ${target.name}] ${args.get(messageArg).joinToString()}")

            // Dispatch the messages
            target.sendMessage(builtMessage)
            sender.sendMessage(builtMessage)
        }
    }

}