package io.github.usbharu.hayasaka.plugin

/**
 * プラグインの仕様のバージョン
 *
 * @property version バージョン名
 * @constructor Create empty Plugin version
 */
enum class PluginVersion(private val version: String) {
    /**
     * バージョン1.0
     *
     * @constructor Create empty V1 0
     */
    V1_0("1.0");
}
