package stomee.social

import net.kyori.adventure.text.Component
import net.minestom.server.command.builder.Command
import net.minestom.server.command.builder.arguments.ArgumentType
import net.minestom.server.entity.Player
import world.cepi.kstom.command.addSyntax

object MessageCommand : Command("msg", "tell", "whisper", "message") {

    init {
        val playerArg = ArgumentType.Entity("target").onlyPlayers(true).singleEntity(true)
        val messageArg = ArgumentType.StringArray("message")
        addSyntax(playerArg, messageArg) { sender, args ->
            sender as Player
            val target = args.get(playerArg).find(sender)[0] as Player
            target.sendMessage(Component.text("[${sender.name} -> ${target.name}] ${args.get(messageArg).joinToString()}"))
            sender.sendMessage(Component.text("[${sender.name} -> ${target.name}] ${args.get(messageArg).joinToString()}"))
        }
    }
}