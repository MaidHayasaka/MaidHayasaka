package io.github.usbharu.hayasaka.plugin.loader

import io.github.usbharu.hayasaka.plugin.Plugin

/**
 * プラグインのインスタンス
 *
 * @property plugin プラグイン
 * @property enabled 有効かどうか
 * @constructor Create empty Plugin instance
 */
class PluginInstance(val plugin: Plugin, var enabled: Boolean) {

}
