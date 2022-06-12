package io.github.usbharu.hayasaka.core.service

/**
 * 登録されているサービスからサービスを取得します
 */
object ServiceFactory {
    /**
     * サービス名を指定して作成します。
     *
     */
    fun createService(serviceName: String): Service {
        val service = (ServiceLoader.SERVICES[serviceName]
            ?: throw IllegalArgumentException("Service $serviceName not found"))
        service.init()
        return service
    }

    /**
     * 最初に読み込まれたサービスで作成します。
     * 読み込まれる順番の保証はありません。
     *
     */
    fun createService(): Service {
        val first = ServiceLoader.SERVICES.values.first()
        first.init()
        return first
    }
}
