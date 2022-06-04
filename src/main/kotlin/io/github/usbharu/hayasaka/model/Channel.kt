package io.github.usbharu.hayasaka.model

class Channel(name: String) : Model() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Channel) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
