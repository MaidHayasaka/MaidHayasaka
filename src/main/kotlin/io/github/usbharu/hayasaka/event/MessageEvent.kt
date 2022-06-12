package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Message

/**
 * メッセージイベント
 *
 * @property message
 * @property messageEventType
 * @property oldMessage
 * @constructor
 *
 * @param source
 */
open class MessageEvent(
    source: Any, val messageEventType: MessageEventType, val message: Message,
    val oldMessage: Message? = null
) : MaidHayasakaEvent(source)
