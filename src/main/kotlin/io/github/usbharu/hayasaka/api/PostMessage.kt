package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Channel
import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.MessageType

/**
 * 投稿するメッセージのリクエスト
 */
data class PostMessage(
    /**
     * 投稿するメッセージ
     */
    val message: String,
    /**
     * 投稿するメッセージのType
     */
    val messageType: MessageType,
    /**
     * 投稿するチャンネル
     */
    val channel: Channel,
    /**
     * 返信先のメッセージ
     */
    val replyTo: Message? = null
) {
    /**
     * 投稿するメッセージのリクエストのビルダー
     */
    class Builder() {
        private lateinit var message: String
        private lateinit var channel: Channel
        private var replyTo: Message? = null
        private var messageType: MessageType = MessageType.PUBLIC

        /**
         * 投稿するメッセージを設定する
         */
        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        /**
         * 投稿するチャンネルを設定する
         */
        fun setChannel(channel: Channel): Builder {
            this.channel = channel
            return this
        }

        /**
         * 返信先のメッセージを設定する
         */
        fun setReplyTo(replyTo: Message?): Builder {
            this.replyTo = replyTo
            return this
        }

        /**
         * 投稿するメッセージのTypeを設定する
         */
        fun setMessageType(messageType: MessageType): Builder {
            this.messageType = messageType
            return this
        }

        /**
         * 投稿するメッセージのリクエストを生成する
         */
        fun build(): PostMessage {
            return PostMessage(message, messageType, channel, replyTo)
        }
    }
}
