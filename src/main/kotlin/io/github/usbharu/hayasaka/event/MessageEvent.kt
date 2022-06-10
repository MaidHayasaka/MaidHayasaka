package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Message

/**
 * メッセージのイベント
 *
 * @property message
 * @constructor
 *
 * @param source
 */
class MessageEvent(source: Any, val message: Message) : MaidHayasakaEvent(source)
