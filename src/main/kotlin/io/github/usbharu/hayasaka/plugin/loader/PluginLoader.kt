package io.github.usbharu.hayasaka.plugin.loader

import io.github.usbharu.hayasaka.plugin.Plugin
import io.github.usbharu.hayasaka.plugin.PluginVersion
import io.github.usbharu.hayasaka.util.ClassFinder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.net.URLClassLoader
import java.nio.file.Paths
import java.util.jar.JarFile
import kotlin.io.path.absolute

/**
 * 特定のフォルダーからプラグインを読み込みます
 */
object PluginLoader {
    /**
     * 読み込まれたプラグインのMAP
     */
    val PLUGINS = HashMap<String, PluginInstance>()
    private val LOGGER: Logger = LoggerFactory.getLogger(PluginLoader::class.java)

    init {
        loadPluginInstances(loadPlugins())
        loadPluginInstances(loadBuiltinPlugins())
    }

    private fun loadPlugins(): List<Plugin> {
        val plugins = ArrayList<Plugin>()
        val uri = Paths.get("plugins").absolute().toUri()
        val file = File(uri)
        if (file.listFiles() == null) {
            LOGGER.warn("No plugins found")
            return plugins
        }
        for (f in file.listFiles()!!) {
            if (f.endsWith(".jar")) {
                val jar = JarFile(f)
                val manifest = jar.manifest
                val className = manifest.mainAttributes.getValue("Plugin-Name")
                val url = f.canonicalFile.toURI().toURL()
                val urlClassLoader = URLClassLoader(arrayOf(url))
                val loadedClass = urlClassLoader.loadClass(className)
                for (loadingClass in loadedClass.interfaces) {
                    if (loadingClass == Plugin::class.java) {
                        LOGGER.info("Loading plugin: {}", className)
                        plugins.add(loadingClass.getDeclaredConstructor().newInstance() as Plugin)
                    }
                }
            }
        }
        return plugins
    }

    private fun loadBuiltinPlugins(): List<Plugin> {
        val plugins = ArrayList<Plugin>()
        for (clazz in ClassFinder.findByPackage("io.github.usbharu.hayasaka.plugins")) {
            if (clazz.interfaces.contains(Plugin::class.java)) {
                LOGGER.info("Loading plugin: {}", clazz.simpleName)
                plugins.add(clazz.getDeclaredConstructor().newInstance() as Plugin)
            }
        }
        return plugins;
    }

    private fun loadPluginInstances(pluginList: List<Plugin>) {
        for (plugin in pluginList) {
            if (plugin.getPluginVersion() == PluginVersion.V1_0) {
                PLUGINS[plugin.getName()] = PluginInstance(plugin, false);
            }
        }
    }
}
