package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Channel
import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.MessageType

interface MessageOperation {
    /**
     * メッセージを送信する
     */
    fun postMessage(postMessage: PostMessage): PostMessageResponse

    fun postMessage(
        message: String,
        messageType: MessageType,
        channel: Channel,
        replyTo: Message? = null
    ): PostMessageResponse
}
