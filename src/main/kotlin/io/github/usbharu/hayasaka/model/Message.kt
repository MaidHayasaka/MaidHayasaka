package io.github.usbharu.hayasaka.model

/**
 * MaidHayasaka上で表される抽象的なメッセージ
 *
 * @property message メッセージ内容
 * @property sender 送信者
 * @property messageType メッセージタイプ
 * @property channel 送信されたチャンネル
 * @constructor Create empty Message
 */
open class Message(
    val message: String,
    val sender: User,
    val messageType: MessageType = MessageType.PUBLIC,
    val channel: Channel
) : Model() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Message) return false

        if (message != other.message) return false
        if (sender != other.sender) return false
        if (messageType != other.messageType) return false
        if (channel != other.channel) return false

        return true
    }

    override fun hashCode(): Int {
        var result = message.hashCode()
        result = 31 * result + sender.hashCode()
        result = 31 * result + messageType.hashCode()
        result = 31 * result + channel.hashCode()
        return result
    }
}
