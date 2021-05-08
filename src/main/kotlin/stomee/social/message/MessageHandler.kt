package stomee.social.message

import net.kyori.adventure.text.Component
import net.minestom.server.command.CommandSender
import net.minestom.server.entity.Player

object MessageHandler {

    private val messageMap = mutableMapOf<CommandSender, CommandSender>()

    /**
     * Notify the system that a [sender] sent a message to a [target]
     */
    fun setLastMessaged(sender: CommandSender, target: CommandSender) {
        messageMap[sender] = target
        messageMap[target] = sender
    }

    /**
     * Get the last person a [sender] replied to.
     */
    fun getLastReply(sender: CommandSender): CommandSender?
        = messageMap[sender]

    fun generateMessage(senderName: String, targetName: String, message: String)
        = Component.text("[$senderName -> $targetName] $message")

    fun username(sender: CommandSender) = if (sender is Player) {
        sender.username
    } else {
        "Console"
    }


}