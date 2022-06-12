package io.github.usbharu.hayasaka.event

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
    REACTION,

    /**
     * メッセージが追加されたイベント
     */
    MESSAGE_ADD,

    /**
     * メッセージが削除されたイベント
     */
    MESSAGE_REMOVE,

    /**
     * メッセージが編集されたイベント
     */
    MESSAGE_EDIT,

    /**
     * リアクションが追加されたイベント
     */
    REACTION_ADD,

    /**
     * リアクションが削除されたイベント
     */
    REACTION_REMOVE
}
