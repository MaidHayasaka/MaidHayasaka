package io.github.usbharu.hayasaka.model

/**
 * メッセージの種類
 *
 * @constructor Create empty Message type
 */
enum class MessageType {
    /**
     * 公開、非スレッド、非返信
     *
     * @constructor Create empty Public
     */
    PUBLIC,

    /**
     * スレッド、返信
     * @constructor Create empty Thread
     */
    THREAD
}
