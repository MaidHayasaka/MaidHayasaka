package io.github.usbharu.hayasaka.core.service

import io.github.usbharu.hayasaka.api.MessageOperation
import io.github.usbharu.hayasaka.api.ReactionOperation

abstract class Service {

    open fun getName(): String {
        return this.javaClass.simpleName
    }

    abstract val messageOperation: MessageOperation
    abstract val reactionOperation: ReactionOperation

    abstract fun init()
    abstract fun start()
    abstract fun stop()
}
