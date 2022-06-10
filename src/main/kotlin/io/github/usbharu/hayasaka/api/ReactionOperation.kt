package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.Reaction

/**
 * リアクションの操作を定義するインターフェイス
 */
interface ReactionOperation {
    /**
     * リアクションを追加する
     */
    fun addReaction(addReaction: AddReaction): ReactionAddedResponse

    /**
     * リアクションを追加する
     */
    fun addReaction(reaction: Reaction, message: Message): ReactionAddedResponse
}
