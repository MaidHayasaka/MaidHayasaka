package io.github.usbharu.hayasaka.service

import io.github.usbharu.hayasaka.api.*
import io.github.usbharu.hayasaka.core.service.Service
import io.github.usbharu.hayasaka.model.*

class TestService : Service() {
    override val messageOperation: MessageOperation
        get() = object : MessageOperation {
            override fun postMessage(postMessage: PostMessage): PostMessageResponse {
                return PostMessageResponse(
                    Message(
                        postMessage.message, User("test"), postMessage.messageType,
                        postMessage.channel
                    )
                )
            }

            override fun postMessage(
                message: String, messageType: MessageType,
                channel: Channel, replyTo: Message?
            ): PostMessageResponse {
                return PostMessageResponse(
                    Message(message, User("test"), messageType, channel)
                )
            }
        }
    override val reactionOperation: ReactionOperation
        get() = object : ReactionOperation {
            override fun addReaction(addReaction: AddReaction): ReactionAddedResponse {
                return ReactionAddedResponse(
                    Reaction(
                        addReaction.reaction,
                        User("test"), addReaction.target
                    )
                )
            }

            override fun addReaction(
                reaction: Reaction,
                message: Message
            ): ReactionAddedResponse {
                return ReactionAddedResponse(
                    Reaction(
                        reaction.name,
                        User("test"), message
                    )
                )
            }
        }
}
