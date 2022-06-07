package io.github.usbharu.hayasaka.plugin

import io.github.usbharu.hayasaka.event.MaidHayasakaEventListener

interface Plugin {

    fun getListeners(): List<MaidHayasakaEventListener>
    fun getPluginVersion(): PluginVersion {
        return PluginVersion.V1_0;
    }

    fun getVersion(): String
    fun getName(): String
    fun getDescription(): String
}
