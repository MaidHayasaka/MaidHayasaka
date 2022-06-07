package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Channel
import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.MessageType

data class PostMessage(
    val message: String,
    val messageType: MessageType,
    val channel: Channel,
    val replyTo: Message? = null
) {
    class Builder() {
        private lateinit var message: String
        private lateinit var channel: Channel
        private var replyTo: Message? = null
        private var messageType: MessageType = MessageType.PUBLIC

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

        fun setMessageType(messageType: MessageType): Builder {
            this.messageType = messageType
            return this
        }

        fun build(): PostMessage {
            return PostMessage(message, messageType, channel, replyTo)
        }
    }
}
