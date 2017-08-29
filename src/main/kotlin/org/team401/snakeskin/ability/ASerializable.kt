package org.team401.snakeskin.ability

import com.google.gson.Gson

/*
 * snakeskin - Created on 8/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/26/17
 */

interface ASerializable {
    fun serialize(gson: Gson): String
}