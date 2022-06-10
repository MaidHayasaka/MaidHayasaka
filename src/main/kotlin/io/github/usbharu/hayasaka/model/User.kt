package io.github.usbharu.hayasaka.model

/**
 * MaidHayasaka上で表される抽象的なユーザー
 *
 * @property name ユーザー名
 * @constructor Create empty User
 */
open class User(val name: String) : Model() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
