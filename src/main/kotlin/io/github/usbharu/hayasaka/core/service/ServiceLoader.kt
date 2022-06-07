package io.github.usbharu.hayasaka.core.service

import io.github.usbharu.hayasaka.util.ClassFinder
import org.slf4j.LoggerFactory
import java.io.File
import java.net.URLClassLoader
import java.nio.file.Paths
import java.util.jar.JarFile
import kotlin.io.path.absolute

object ServiceLoader {
    val SERVICES = HashMap<String, Service>()
    private val LOGGER = LoggerFactory.getLogger(ServiceLoader::class.java)

    init {
        for (service in loadService()) {
            SERVICES[service.getName()] = service
        }
        for (service in loadBuiltinService()) {
            SERVICES[service.getName()] = service
        }
    }

    private fun loadService(): List<Service> {
        val serviceList = ArrayList<Service>()
        val uri = Paths.get("services").absolute().toUri()
        val file = File(uri)
        if (file.listFiles() == null) {
            LOGGER.warn("No service found")
            return serviceList
        }
        for (f in file.listFiles()!!) {
            if (f.endsWith(".jar")) {
                val jarFile = JarFile(f)
                val manifest = jarFile.manifest
                val serviceName = manifest.mainAttributes.getValue("Service-Name")
                val url = f.canonicalFile.toURI().toURL()
                val urlClassLoader = URLClassLoader(arrayOf(url))
                val loadingClass = urlClassLoader.loadClass(serviceName)
                for (loadedClass in loadingClass.interfaces) {
                    if (loadedClass == Service::class.java) {
                        LOGGER.info("Loading service: {}", serviceName)
                        serviceList.add(
                            loadingClass.getDeclaredConstructor().newInstance() as Service
                        )
                    }
                }

            }
        }
        return serviceList
    }

    private fun loadBuiltinService(): List<Service> {
        val services = ArrayList<Service>()
        val findByPackage = ClassFinder.findByPackage("io.github.usbharu.hayasaka.service")
        for (clazz in findByPackage) {
            if (clazz.superclass.equals(Service::class.java)) {
                LOGGER.info("Loading builtin service: {}", clazz.simpleName)
                services.add(clazz.getDeclaredConstructor().newInstance() as Service)
            }
        }
        return services
    }
}
