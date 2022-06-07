package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Channel
import io.github.usbharu.hayasaka.model.Message

data class PostMessage(val message: String, val channel: Channel, val replyTo: Message? = null) {
    class Builder() {
        private lateinit var message: String
        private lateinit var channel: Channel
        private var replyTo: Message? = null

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setChannel(channel: Channel): Builder {
            this.channel = channel
            return this
        }

        fun setReplyTo(replyTo: Message?): Builder {
            this.replyTo = replyTo
            return this
        }

        fun build(): PostMessage {
            return PostMessage(message, channel, replyTo)
        }
    }
}
