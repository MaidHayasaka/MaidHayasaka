package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Reaction

/**
 * リアクションのイベント
 *
 * @property reaction リアクション
 * @property MessageEventType メッセージイベントのタイプ
 * @constructor
 *
 * @param source
 */
open class ReactionEvent(
    source: Any,
    private val reaction: Reaction,
    reactionEventType: ReactionEventType
) : MaidHayasakaEvent(source)
