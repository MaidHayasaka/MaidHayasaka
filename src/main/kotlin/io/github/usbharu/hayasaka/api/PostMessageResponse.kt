package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Message

/**
 * メッセージを投稿した際のレスポンス
 */
data class PostMessageResponse(
    /**
     * 投稿されたメッセージ
     */
    val message: Message
)
