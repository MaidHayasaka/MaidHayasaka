package io.github.usbharu.hayasaka

import io.github.usbharu.hayasaka.core.EventManager
import io.github.usbharu.hayasaka.core.service.ServiceFactory
import io.github.usbharu.hayasaka.core.service.ServiceLoader
import io.github.usbharu.hayasaka.event.Event
import io.github.usbharu.hayasaka.event.EventType
import io.github.usbharu.hayasaka.model.Channel
import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.MessageType
import io.github.usbharu.hayasaka.model.User
import io.github.usbharu.hayasaka.plugin.loader.PluginLoader
import org.slf4j.LoggerFactory

val LOGGER = LoggerFactory.getLogger("MaidHayasaka")!!

/**
 * エントリーポイント
 *
 */
fun main() {
    LOGGER.info("MaidHayasaka started.")
    LOGGER.debug(ServiceLoader.SERVICES.toString())
    val createService = ServiceFactory.createService()
    Runtime.getRuntime().addShutdownHook(Thread {
        run {
            createService.stop()
        }
    })
    createService.start()
    for (plugin in PluginLoader.PLUGINS) {
        for (listener in plugin.value.plugin.getListeners()) {
            EventManager.addMaidHayasakaEventListener(listener)
        }
    }
    EventManager.event(
        Event(
            EventType.MESSAGE, Message(
                "Hello, world!", User("hayasaka"), MessageType.PUBLIC, Channel("#hayasaka")
            )
        )
    )
    while (true) {
        if (Thread.interrupted()) {
            break;
        }
    }
}
