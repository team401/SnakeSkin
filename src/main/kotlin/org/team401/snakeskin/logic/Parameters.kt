package org.team401.snakeskin.logic

import org.team401.snakeskin.exception.ParameterNotFoundException

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

class Parameters {
    protected val strings: HashMap<String, String>
    protected val booleans: HashMap<String, Boolean>
    protected val numbers: HashMap<String, Double>
    protected val others: HashMap<String, Any>

    constructor(strings: HashMap<String, String>, booleans: HashMap<String, Boolean>, numbers: HashMap<String, Double>, others: HashMap<String, Any>) {
        this.strings = strings
        this.booleans = booleans
        this.numbers = numbers
        this.others = others
    }

    constructor() {
        strings = hashMapOf()
        booleans = hashMapOf()
        numbers = hashMapOf()
        others = hashMapOf()
    }

    fun getString(string: String): String {
        if (strings.containsKey(string)) {
            return strings[string]!!
        } else {
            throw ParameterNotFoundException("The STRING parameter [$string] was not found!")
        }
    }

    fun getBoolean(boolean: String): Boolean {
        if (booleans.containsKey(boolean)) {
            return booleans[boolean]!!
        } else {
            throw ParameterNotFoundException("The BOOLEAN parameter [$boolean] was not found!")
        }
    }

    fun getNumber(number: String): Double {
        if (numbers.containsKey(number)) {
            return numbers[number]!!
        } else {
            throw ParameterNotFoundException("The NUMERIC parameter [$number] was not found!")
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getOther(other: String): T {
        if (others.containsKey(other)) {
            return others[other]!! as T
        } else {
            throw ParameterNotFoundException("The OTHER parameter [$other] was not found!")
        }
    }
}