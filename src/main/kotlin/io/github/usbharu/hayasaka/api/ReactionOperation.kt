package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.Reaction

interface ReactionOperation {
    fun addReaction(addReaction: AddReaction): ReactionAddedResponse
    fun addReaction(reaction: Reaction, message: Message): ReactionAddedResponse
}
