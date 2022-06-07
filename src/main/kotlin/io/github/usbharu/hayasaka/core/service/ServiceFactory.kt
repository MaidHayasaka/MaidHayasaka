package io.github.usbharu.hayasaka.core.service

object ServiceFactory {
    fun createService(serviceName: String): Service {
        val service = (ServiceLoader.SERVICES[serviceName]
            ?: throw IllegalArgumentException("Service $serviceName not found"))
        service.init()
        return service
    }

    fun createService(): Service {
        val first = ServiceLoader.SERVICES.values.first()
        first.init()
        return first
    }
}
