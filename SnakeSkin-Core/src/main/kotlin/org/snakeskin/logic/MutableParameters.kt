package org.snakeskin.logic

import org.snakeskin.exception.ItemNotFoundException

/**
 * @author Cameron Earle
 * @version 7/8/17
 */
class MutableParameters {
    private val strings: HashMap<String, String> = hashMapOf()
    private val booleans: HashMap<String, Boolean> = hashMapOf()
    private val numbers: HashMap<String, Double> = hashMapOf()
    private val others: HashMap<String, Any> = hashMapOf()

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

    fun setString(string: String, value: String) {
        if (!strings.containsKey(string)) {
            strings.put(string, value)
        } else {
            strings[string] = value
        }
    }

    fun setBoolean(boolean: String, value: Boolean) {
        if (!booleans.containsKey(boolean)) {
            booleans.put(boolean, value)
        } else {
            booleans[boolean] = value
        }
    }

    fun setNumber(number: String, value: Double) {
        if (!numbers.containsKey(number)) {
            numbers.put(number, value)
        } else {
            numbers[number] = value
        }
    }

    fun setOther(other: String, value: Any) {
        if (!others.containsKey(other)) {
            others.put(other, value)
        } else {
            others[other] = value
        }
    }

    fun toParameters(): Parameters {
        return Parameters(strings, booleans, numbers, others)
    }
}