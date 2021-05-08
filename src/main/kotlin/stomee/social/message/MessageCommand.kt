package stomee.social.message

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
            val senderName = MessageHandler.username(sender)

            // Grab the target
            val target = args.get(playerArg).find(sender)[0] as Player

            // Pre-build the message
            val builtMessage = MessageHandler.generateMessage(senderName, target.username, args.get(messageArg).joinToString())

            // Dispatch the messages
            MessageHandler.setLastMessaged(sender, target)
            target.sendMessage(builtMessage)
            sender.sendMessage(builtMessage)
        }
    }

}