package io.github.usbharu.hayasaka.core

import io.github.usbharu.hayasaka.event.*
import io.github.usbharu.hayasaka.model.EventType
import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.Reaction
import javax.swing.event.EventListenerList

class EventManager {
    private val eventListenerList = EventListenerList()

    fun addMessageListener(listener: MessageEventListener) {
        eventListenerList.add(MessageEventListener::class.java, listener)
    }

    fun removeMessageListener(listener: MessageEventListener) {
        eventListenerList.remove(MessageEventListener::class.java, listener)
    }

    fun addReactionListener(listener: ReactionEventListener) {
        eventListenerList.add(ReactionEventListener::class.java, listener)
    }

    fun removeReactionListener(listener: ReactionEventListener) {
        eventListenerList.remove(ReactionEventListener::class.java, listener)
    }

    private fun fireMessageEvent(event: Event) {
        if (event.model is Message) {
            val listeners = eventListenerList.getListeners(MessageEventListener::class.java)
            for (listener in listeners) {
                listener.onMessageEvent(MessageEvent(this, event.model))
            }
        }
    }

    private fun fireReactionEvent(event: Event) {
        if (event.model is Reaction) {
            val listeners = eventListenerList.getListeners(ReactionEventListener::class.java)
            for (listener in listeners) {
                listener.onReaction(ReactionEvent(this, event.model))
            }
        }
    }

    fun event(event: Event) {
        when (event.eventType) {
            EventType.MESSAGE -> fireMessageEvent(event)
            EventType.REACTION -> fireReactionEvent(event)
        }
    }
}
