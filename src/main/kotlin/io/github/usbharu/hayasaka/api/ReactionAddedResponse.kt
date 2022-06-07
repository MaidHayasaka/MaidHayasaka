package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Reaction

/**
 * リアクションが追加された際のレスポンス
 */
data class ReactionAddedResponse(
    /**
     * 追加されたリアクション
     */
    val reaction: Reaction
)
