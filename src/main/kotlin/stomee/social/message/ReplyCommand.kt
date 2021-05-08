package stomee.social.message

import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.arguments.ArgumentType
import world.cepi.kstom.command.addSyntax

object ReplyCommand : Command("reply", "r") {

    init {
        val messageArg = ArgumentType.StringArray("message")

        addSyntax(messageArg) { sender, args ->

            if (MessageHandler.getLastReply(sender) == null) return@addSyntax

            val target = MessageHandler.getLastReply(sender)!!

            val builtMessage = MessageHandler.generateMessage(
                MessageHandler.username(sender),
                MessageHandler.username(target),
                args.get(messageArg).joinToString()
            )

            sender.sendMessage(builtMessage)
            target.sendMessage(builtMessage)

        }
    }

}