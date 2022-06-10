package io.github.usbharu.hayasaka.event

/**
 * リアクションのイベントのリスナー
 */
interface ReactionEventListener : MaidHayasakaEventListener {
    /**
     * リアクションのイベントが発生
     */
    fun onReaction(reaction: ReactionEvent)
}
