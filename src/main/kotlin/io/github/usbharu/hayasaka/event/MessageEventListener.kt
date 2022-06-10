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
}
