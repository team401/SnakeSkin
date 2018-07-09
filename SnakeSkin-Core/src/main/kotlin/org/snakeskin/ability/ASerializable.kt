package org.snakeskin.ability

import com.google.gson.Gson

/**
 * @author Cameron Earle
 * @version 8/26/17
 */
interface ASerializable {
    fun serialize(gson: Gson): String
}