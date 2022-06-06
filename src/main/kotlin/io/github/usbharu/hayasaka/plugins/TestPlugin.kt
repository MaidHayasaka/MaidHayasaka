package io.github.usbharu.hayasaka.plugins

import io.github.usbharu.hayasaka.plugin.Plugin

class TestPlugin : Plugin {
    override fun getVersion(): String {
        return "1.0.0"
    }

    override fun getName(): String {
        return "TestPlugin"
    }

    override fun getDescription(): String {
        return "TestPlugin"
    }
}
