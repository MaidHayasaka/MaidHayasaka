package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Message
import java.util.*

class MessageEvent(source: Any, val message: Message) : EventObject(source) {
}
