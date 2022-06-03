package io.github.usbharu.hayasaka.model

data class Message(val message: String, val sender: User, val messageType: MessageType) : Model()
