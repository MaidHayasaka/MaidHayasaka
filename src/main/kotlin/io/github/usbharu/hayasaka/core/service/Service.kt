package io.github.usbharu.hayasaka.core.service

import io.github.usbharu.hayasaka.api.MessageOperation
import io.github.usbharu.hayasaka.api.ReactionOperation

/**
 * SlackやDiscordなどのサービス
 */
abstract class Service {

    /**
     * サービス名
     */
    open fun getName(): String {
        return this.javaClass.simpleName
    }

    /**
     * メッセージの操作をするクラス
     */
    abstract val messageOperation: MessageOperation

    /**
     * リアクションの操作をするクラス
     */
    abstract val reactionOperation: ReactionOperation

    /**
     * 初期化
     */
    abstract fun init()

    /**
     * 開始処理
     */
    abstract fun start()

    /**
     * 終了処理
     */
    abstract fun stop()
}
