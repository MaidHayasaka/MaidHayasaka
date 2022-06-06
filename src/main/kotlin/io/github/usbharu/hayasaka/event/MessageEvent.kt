package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Message

class MessageEvent(source: Any, val message: Message) : MaidHayasakaEvent(source)
