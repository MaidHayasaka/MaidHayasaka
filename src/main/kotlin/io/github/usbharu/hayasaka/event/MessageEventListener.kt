package io.github.usbharu.hayasaka.event

interface MessageEventListener : MaidHayasakaEventListener {
    fun onMessageEvent(event: MessageEvent)
}
