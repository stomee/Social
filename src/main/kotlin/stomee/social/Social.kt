package stomee.social

import net.minestom.server.extensions.Extension;

class Social : Extension() {

    override fun initialize() {
        logger.info("[Social] has been enabled!")
    }

    override fun terminate() {
        logger.info("[Social] has been disabled!")
    }

}