package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Message

data class AddReaction(val reaction: String, val target: Message) {
    class Builder() {
        private lateinit var reaction: String
        private lateinit var target: Message

        fun setReaction(reaction: String): Builder {
            this.reaction = reaction
            return this
        }

        fun setTarget(target: Message): Builder {
            this.target = target
            return this
        }

        fun build(): AddReaction {
            return AddReaction(reaction, target)
        }
    }
}
