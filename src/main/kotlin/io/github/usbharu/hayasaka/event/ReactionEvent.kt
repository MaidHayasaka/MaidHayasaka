package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Reaction

/**
 * リアクションのイベント
 *
 * @property reaction リアクション
 * @constructor
 *
 * @param source
 */
class ReactionEvent(source: Any, private val reaction: Reaction) : MaidHayasakaEvent(source)
