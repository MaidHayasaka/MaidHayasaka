package io.github.usbharu.hayasaka.event

import java.util.*

interface MessageEventListener : EventListener {
    fun onMessageEvent(event: MessageEvent)
}
