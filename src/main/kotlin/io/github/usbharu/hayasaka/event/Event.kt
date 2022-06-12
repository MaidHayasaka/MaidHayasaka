package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Model

/**
 * MaidHayasaka上で起こったすべてのPlugin用のイベントの上位クラス
 *
 * @property eventType
 * @property model
 * @property oldModel
 * @constructor Create empty Event
 */
data class Event(val eventType: EventType, val model: Model, val oldModel: Model? = null)
