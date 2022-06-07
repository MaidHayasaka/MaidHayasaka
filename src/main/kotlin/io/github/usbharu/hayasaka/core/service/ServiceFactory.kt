package io.github.usbharu.hayasaka.core.service

object ServiceFactory {
    fun createService(serviceName: String): Service {
        return ServiceLoader.SERVICES[serviceName]
            ?: throw IllegalArgumentException("Service $serviceName not found");
    }

    fun createService(): Service {
        return ServiceLoader.SERVICES.values.first()
    }
}
