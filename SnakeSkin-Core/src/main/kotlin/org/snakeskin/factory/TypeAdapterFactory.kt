package org.snakeskin.factory

/**
 * @author Cameron Earle
 * @version 12/25/17
 */
class TypeAdapterFactory<T> {
    private val adapters = hashMapOf<Class<*>, (Any) -> T>()
    fun registerAdapter(clazz: Class<*>, handler: (Any) -> T) = adapters.put(clazz, handler)

    fun adapt(item: Any): T? {
        var clazz: Class<*>? = item::class.java
        while (clazz != null) {
            if (adapters.containsKey(clazz)) {
                return adapters[clazz]!!.invoke(item)
            }
            clazz.interfaces.forEach {
                if (adapters.containsKey(it)) {
                    return adapters[it]!!.invoke(item)
                }
            }
            clazz = clazz.superclass
        }
        return null
    }
}