package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.EventType
import io.github.usbharu.hayasaka.model.Model

data class Event(val eventType: EventType, val model: Model)
