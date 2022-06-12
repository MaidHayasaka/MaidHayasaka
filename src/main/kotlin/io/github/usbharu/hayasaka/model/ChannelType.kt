package io.github.usbharu.hayasaka.model

/**
 * チャンネルの種類
 *
 * @constructor Create empty Channel type
 */
enum class ChannelType {
    /**
     * 公開
     *
     * @constructor Create empty Public
     */
    PUBLIC,

    /**
     * 非公開
     *
     * @constructor Create empty Private
     */
    PRIVATE,

    /**
     * ダイレクトメッセージ、私信
     *
     * @constructor Create empty Direct
     */
    DIRECT
}
