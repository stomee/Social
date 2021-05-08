package stomee.social

import net.minestom.server.extensions.Extension;
import stomee.social.message.MessageCommand
import stomee.social.message.ReplyCommand
import world.cepi.kstom.Manager
import world.cepi.kstom.command.register
import world.cepi.kstom.command.unregister

class Social : Extension() {

    override fun initialize() {

        Manager.connection.addPlayerInitialization(::hook)

        DiscordCommand.register()
        MessageCommand.register()
        ReplyCommand.register()

        logger.info("[Social] has been enabled!")
    }

    override fun terminate() {

        Manager.connection.removePlayerInitialization(::hook)

        DiscordCommand.unregister()
        MessageCommand.unregister()
        ReplyCommand.unregister()

        logger.info("[Social] has been disabled!")
    }

}