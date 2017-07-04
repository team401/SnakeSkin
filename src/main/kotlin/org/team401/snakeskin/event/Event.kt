package org.team401.snakeskin.event

/*
 * SnakeSkin - Created on 7/4/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/4/17
 */

data class Event(val strings: HashMap<String, String>,
                 val booleans: HashMap<String, Boolean>,
                 val numbers: HashMap<String, Double>,
                 val others: HashMap<String, Any>)