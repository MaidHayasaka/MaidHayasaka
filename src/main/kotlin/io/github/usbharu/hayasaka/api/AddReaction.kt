package io.github.usbharu.hayasaka.api

import io.github.usbharu.hayasaka.model.Message

/**
 * メッセージに追加するリアクションのリクエスト
 */
data class AddReaction(
    /**
     * 追加するリアクションのid
     */
    val reaction: String,
    /**
     * 追加するメッセージ
     */
    val target: Message
) {
    /**
     * 追加するリアクションのビルダー
     */
    class Builder() {
        private lateinit var reaction: String
        private lateinit var target: Message

        /**
         * 追加するリアクションのidを設定する
         */
        fun setReaction(reaction: String): Builder {
            this.reaction = reaction
            return this
        }

        /**
         * 追加するメッセージを設定する
         */
        fun setTarget(target: Message): Builder {
            this.target = target
            return this
        }

        /**
         * リクエストを作成する
         */
        fun build(): AddReaction {
            return AddReaction(reaction, target)
        }
    }
}
