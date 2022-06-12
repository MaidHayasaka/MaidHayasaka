package io.github.usbharu.hayasaka.plugins

import io.github.usbharu.hayasaka.event.MaidHayasakaEventListener
import io.github.usbharu.hayasaka.event.MessageEvent
import io.github.usbharu.hayasaka.event.MessageEventListener
import io.github.usbharu.hayasaka.plugin.Plugin

/**
 * テストプラグイン
 *
 * @constructor Create empty Test plugin
 */
class TestPlugin : Plugin {
    override fun getListeners(): List<MaidHayasakaEventListener> {
        val messageEventListener: MessageEventListener = object : MessageEventListener {
            override fun onMessageEvent(event: MessageEvent) {
                println("MessageEventListener")
            }

            override fun addMessage(event: MessageEvent) {
                println("add message")
            }

            override fun removeMessage(event: MessageEvent) {
                println("remove message")
            }

            override fun editMessage(event: MessageEvent) {
                println("edit message")
            }
        }
        return listOf(messageEventListener)

    }

    override fun getVersion(): String {
        return "1.0.0"
    }

    override fun getName(): String {
        return "TestPlugin"
    }

    override fun getDescription(): String {
        return "TestPlugin"
    }
}
