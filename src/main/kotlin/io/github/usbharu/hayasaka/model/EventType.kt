package io.github.usbharu.hayasaka.model

/**
 * イベントの種類
 *
 * @constructor Create empty Event type
 */
enum class EventType {
    /**
     * メッセージに関するイベント
     *
     * @constructor Create empty Message
     */
    MESSAGE,

    /**
     * リアクションに関するイベント
     *
     * @constructor Create empty Reaction
     */
    REACTION
}
