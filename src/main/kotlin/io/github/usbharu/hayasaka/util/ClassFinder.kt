package io.github.usbharu.hayasaka.util

import java.io.File
import java.io.IOException
import java.net.JarURLConnection
import java.util.*
import java.util.concurrent.Callable
import java.util.jar.JarEntry
import java.util.stream.Collectors

/**
 * クラスを検索するためのユーティリティクラス
 */
object ClassFinder {
    /**
     * 指定されたパッケージ内のクラスを検索します。
     */
    fun findByPackage(packageName: String): Set<Class<*>> {
        val resourceName = packageName.replace(".", "/")
        val contextClassLoader = Thread.currentThread().contextClassLoader
        val root = contextClassLoader.getResource(resourceName) ?: return HashSet()
        if ("file" == root.protocol) {
            val files =
                File(root.file).listFiles { _: File?, name: String -> name.endsWith(".class") }
            return listOf(*files!!).stream()
                .map { file: File -> file.name }
                .map { name: String -> name.replace(".class$".toRegex(), "") }
                .map { name: String -> "$packageName.$name" }
                .map { fullName: String? ->
                    uncheckCall { Class.forName(fullName) }
                }
                .collect(Collectors.toSet())
        } else if ("jar" == root.protocol) {
            try {
                (root.openConnection() as JarURLConnection).jarFile.use { jarFile ->
                    return Collections.list(jarFile.entries()).stream()
                        .map { jarEntry: JarEntry -> jarEntry.name }
                        .filter { name: String -> name.startsWith(resourceName) }
                        .filter { name: String -> name.endsWith(".class") }
                        .map { name: String ->
                            name.replace("/".toRegex(), ".").replace(".class$".toRegex(), "")
                        }
                        .map { fullName: String? ->
                            uncheckCall { Class.forName(fullName) }
                        }
                        .collect(Collectors.toSet())
                }
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
        return HashSet()
    }

    private fun <T> uncheckCall(callable: Callable<T>): T {
        return try {
            callable.call()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
