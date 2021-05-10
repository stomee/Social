package stomee.social

import net.minestom.server.extensions.Extension;
import stomee.social.message.MessageCommand
import stomee.social.message.ReplyCommand
import world.cepi.kstom.Manager
import world.cepi.kstom.command.register
import world.cepi.kstom.command.unregister

class Social : Extension() {

    override fun initialize() {

        Manager.connection.addPlayerInitialization(::joinLeaveHook)
        Manager.connection.addPlayerInitialization(::tablistHook)

        DiscordCommand.register()
        MessageCommand.register()
        ReplyCommand.register()

        logger.info("[Social] has been enabled!")
    }

    override fun terminate() {

        Manager.connection.removePlayerInitialization(::joinLeaveHook)
        Manager.connection.addPlayerInitialization(::tablistHook)

        DiscordCommand.unregister()
        MessageCommand.unregister()
        ReplyCommand.unregister()

        logger.info("[Social] has been disabled!")
    }

}