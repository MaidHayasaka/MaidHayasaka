package io.github.usbharu.hayasaka

import io.github.usbharu.hayasaka.core.EventManager
import io.github.usbharu.hayasaka.core.service.ServiceFactory
import io.github.usbharu.hayasaka.event.Event
import io.github.usbharu.hayasaka.model.*
import io.github.usbharu.hayasaka.plugin.loader.PluginLoader

fun main() {
    ServiceFactory.createService().start()
    for (plugin in PluginLoader.PLUGINS) {
        for (listener in plugin.value.plugin.getListeners()) {
            EventManager.addMaidHayasakaListener(listener)
        }
    }
    EventManager.event(
        Event(
            EventType.MESSAGE, Message(
                "Hello, world!", User("hayasaka"), MessageType.PUBLIC, Channel("#hayasaka")
            )
        )
    )

}
