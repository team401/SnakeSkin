package org.snakeskin.ability

import com.google.gson.Gson

/**
 * @author Cameron Earle
 * @version 8/26/17
 */
interface ALoggable: ASerializable {
    val type: String

    override fun serialize(gson: Gson): String = gson.toJson(this)
}