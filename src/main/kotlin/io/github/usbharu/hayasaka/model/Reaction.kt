package io.github.usbharu.hayasaka.model

open class Reaction(val name: String, val sender: User, val target: Message) : Model() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Reaction) return false

        if (name != other.name) return false
        if (sender != other.sender) return false
        if (target != other.target) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + sender.hashCode()
        result = 31 * result + target.hashCode()
        return result
    }
}
