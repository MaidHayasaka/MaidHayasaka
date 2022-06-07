package io.github.usbharu.hayasaka.model

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
