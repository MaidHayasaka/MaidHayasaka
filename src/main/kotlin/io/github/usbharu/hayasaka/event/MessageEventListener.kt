package io.github.usbharu.hayasaka.event

/**
 * メッセージのイベントリスナー
 *
 * @constructor Create empty Message event listener
 */
interface MessageEventListener : MaidHayasakaEventListener {
    /**
     * メッセージイベントが発生したとき
     *
     * @param event
     */
    fun onMessageEvent(event: MessageEvent)

    /**
     * メッセージが追加されたとき
     */
    fun addMessage(event: MessageEvent)

    /**
     * メッセージが削除されたとき
     */
    fun removeMessage(event: MessageEvent)

    /**
     * メッセージが編集されたとき
     *
     * @param event
     */
    fun editMessage(event: MessageEvent)
}
