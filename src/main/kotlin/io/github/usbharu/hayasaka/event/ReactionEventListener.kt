package io.github.usbharu.hayasaka.event

/**
 * リアクションのイベントのリスナー
 */
interface ReactionEventListener : MaidHayasakaEventListener {
    /**
     * リアクションのイベントが発生
     */
    @Deprecated("使用不可")
    fun onReaction(reaction: ReactionEvent)

    /**
     * リアクションが追加された
     */
    fun addReaction(reaction: ReactionEvent)

    /**
     * リアクションが削除された
     */
    fun removeReaction(reaction: ReactionEvent)
}
