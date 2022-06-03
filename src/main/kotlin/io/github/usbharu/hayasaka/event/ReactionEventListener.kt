package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Reaction

interface ReactionEventListener {
    fun onReaction(reaction: Reaction)
}
