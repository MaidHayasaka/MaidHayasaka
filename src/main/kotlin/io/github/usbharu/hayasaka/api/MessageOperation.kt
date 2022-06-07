package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Channel
import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.MessageType

/**
 * メッセージの操作を定義するインターフェイス
 */
interface MessageOperation {
    /**
     * メッセージを送信する
     */
    fun postMessage(postMessage: PostMessage): PostMessageResponse

    /**
     * メッセージを送信する
     */
    fun postMessage(
        message: String,
        messageType: MessageType,
        channel: Channel,
        replyTo: Message? = null
    ): PostMessageResponse
}
