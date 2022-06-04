package io.github.usbharu.hayasaka.plugin

interface Plugin {
    fun getPluginVersion(): PluginVersion {
        return PluginVersion.V1_0;
    }

    fun getVersion(): String
    fun getName(): String
    fun getDescription(): String
}
