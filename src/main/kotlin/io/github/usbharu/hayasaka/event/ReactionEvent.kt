package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Reaction
import java.util.*

class ReactionEvent(source: Any, val reaction: Reaction) : EventObject(source) {
}
