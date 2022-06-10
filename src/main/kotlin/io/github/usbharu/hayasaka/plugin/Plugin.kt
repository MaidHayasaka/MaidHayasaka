package io.github.usbharu.hayasaka.plugin

import io.github.usbharu.hayasaka.event.MaidHayasakaEventListener

/**
 * プラグイン
 *
 * @constructor Create empty Plugin
 */
interface Plugin {

    /**
     * このインターフェースを実装したプラグインが実装しているイベントリスナーのリスト
     *
     * @return
     */
    fun getListeners(): List<MaidHayasakaEventListener>

    /**
     * このインターフェースを実装したプラグインの仕様を定義したバージョン
     *
     * @return
     */
    fun getPluginVersion(): PluginVersion {
        return PluginVersion.V1_0;
    }

    /**
     * プラグインのバージョン
     *
     * @return
     */
    fun getVersion(): String

    /**
     * プラグイン名
     *
     * @return
     */
    fun getName(): String

    /**
     * プラグインの説明
     *
     * @return
     */
    fun getDescription(): String
}
