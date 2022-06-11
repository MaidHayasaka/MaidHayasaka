package io.github.usbharu.hayasaka.core

import io.github.usbharu.hayasaka.event.*
import io.github.usbharu.hayasaka.model.EventType
import io.github.usbharu.hayasaka.model.Message
import io.github.usbharu.hayasaka.model.Reaction
import javax.swing.event.EventListenerList

/**
 * pluginで使用できる全てのイベントを管理するクラス
 *
 */
object EventManager {
    private val eventListenerList = EventListenerList()

    /**
     * メッセージイベントのリスナーを追加します
     */
    fun addMessageEventListener(listener: MessageEventListener) {
        eventListenerList.add(MessageEventListener::class.java, listener)
    }

    /**
     * メッセージイベントのリスナーを削除します。
     * @param listener
     */
    fun removeMessageEventListener(listener: MessageEventListener) {
        eventListenerList.remove(MessageEventListener::class.java, listener)
    }

    /**
     * リアクションイベントのリスナーを追加します。
     *
     * @param listener
     */
    fun addReactionEventListener(listener: ReactionEventListener) {
        eventListenerList.add(ReactionEventListener::class.java, listener)
    }

    /**
     * リアクションイベントのリスナーを削除します。
     */
    fun removeReactionEventListener(listener: ReactionEventListener) {
        eventListenerList.remove(ReactionEventListener::class.java, listener)
    }

    /**
     * イベントのリスナーを追加します。
     * ここで追加された全てのイベントは自動で判別され、適切なタイミングでイベントが発火します。
     */
    fun addMaidHayasakaEventListener(listener: MaidHayasakaEventListener) {
        eventListenerList.add(MaidHayasakaEventListener::class.java, listener)
    }

    /**
     * イベントのリスナーを削除します。
     */
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

    /**
     * イベントを発生させます。
     */
    fun event(event: Event) {
        when (event.eventType) {
            EventType.MESSAGE -> fireMessageEvent(event)
            EventType.REACTION -> fireReactionEvent(event)
        }
    }
}
