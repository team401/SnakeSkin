package org.snakeskin.logic

import org.snakeskin.exception.ItemNotFoundException

/**
 * @author Cameron Earle
 * @version 7/4/17
 */
@Deprecated("Parameters are no longer used by the event system")
class Parameters {
    private val strings: HashMap<String, String>
    private val booleans: HashMap<String, Boolean>
    private val numbers: HashMap<String, Double>
    private val others: HashMap<String, Any>

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
            throw ItemNotFoundException("The STRING parameter [$string] was not found!")
        }
    }

    fun getBoolean(boolean: String): Boolean {
        if (booleans.containsKey(boolean)) {
            return booleans[boolean]!!
        } else {
            throw ItemNotFoundException("The BOOLEAN parameter [$boolean] was not found!")
        }
    }

    fun getNumber(number: String): Double {
        if (numbers.containsKey(number)) {
            return numbers[number]!!
        } else {
            throw ItemNotFoundException("The NUMERIC parameter [$number] was not found!")
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getOther(other: String): T {
        if (others.containsKey(other)) {
            return others[other]!! as T
        } else {
            throw ItemNotFoundException("The OTHER parameter [$other] was not found!")
        }
    }
}