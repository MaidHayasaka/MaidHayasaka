package io.github.usbharu.hayasaka.event

import java.util.*

interface ReactionEventListener : EventListener {
    fun onReaction(reaction: ReactionEvent)
}
