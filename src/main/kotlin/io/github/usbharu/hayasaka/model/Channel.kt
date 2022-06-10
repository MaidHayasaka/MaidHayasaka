package io.github.usbharu.hayasaka.model

/**
 * MaidHayasaka上で表される抽象的なチャンネル
 * @param name チャンネル名
 * @param channel チャンネルタイプ デフォルトはPUBLIC
 */
open class Channel(name: String, channel: ChannelType = ChannelType.PUBLIC) : Model() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Channel) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
