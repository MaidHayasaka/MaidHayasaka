package io.github.usbharu.hayasaka.event

interface ReactionEventListener : MaidHayasakaEventListener {
    fun onReaction(reaction: ReactionEvent)
}
