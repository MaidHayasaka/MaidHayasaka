package io.github.usbharu.hayasaka.plugin

/**
 * 抽象化されたplugin
 *
 * @constructor Create empty Abstract plugin
 */
abstract class AbstractPlugin : Plugin {
    override fun getVersion(): String {
        return "1.0.0"
    }

    override fun getName(): String {
        return "AbstractPlugin"
    }

    override fun getDescription(): String {
        return "AbstractPlugin"
    }
}
