package stomee.social

import net.minestom.server.extensions.Extension;
import world.cepi.kstom.command.register
import world.cepi.kstom.command.unregister

class Social : Extension() {

    override fun initialize() {
        DiscordCommand.register()
        MessageCommand.register()

        logger.info("[Social] has been enabled!")
    }

    override fun terminate() {
        DiscordCommand.unregister()
        MessageCommand.unregister()
        logger.info("[Social] has been disabled!")
    }

}