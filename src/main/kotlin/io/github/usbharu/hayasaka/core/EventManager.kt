package io.github.usbharu.hayasaka.core

import io.github.usbharu.hayasaka.event.*
import io.github.usbharu.hayasaka.model.EventType
import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.Reaction
import javax.swing.event.EventListenerList

object EventManager {
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

    fun addMaidHayasakaListener(listener: MaidHayasakaEventListener) {
        eventListenerList.add(MaidHayasakaEventListener::class.java, listener)
    }

    fun removeMaidHayasakaListener(listener: MaidHayasakaEventListener) {
        eventListenerList.remove(MaidHayasakaEventListener::class.java, listener)
    }

    private fun fireMessageEvent(event: Event) {
        if (event.model is Message) {
            val listenerList = eventListenerList.listenerList
            val event1 = MessageEvent(this, event.model)
            for (listener in listenerList) {
                if (listener is MessageEventListener) {
                    listener.onMessageEvent(event1)
                }
            }
        }
    }

    private fun fireReactionEvent(event: Event) {
        if (event.model is Reaction) {
            val listenerList = eventListenerList.listenerList
            val event1 = ReactionEvent(this, event.model)
            for (listener in listenerList) {
                if (listener is ReactionEventListener) {
                    listener.onReaction(event1)
                }
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
