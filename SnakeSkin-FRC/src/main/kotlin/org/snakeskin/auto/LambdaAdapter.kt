package org.snakeskin.auto

/*
 * snakeskin - Created on 11/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 11/26/17
 */

class LambdaAdapter(lambdaIn: Function0<*>): LambdaAutoStep() {
    init {
        try {
            @Suppress("UNCHECKED_CAST")
            entry = lambdaIn as () -> Unit
        } catch (e: ClassCastException) {
            throw IllegalArgumentException("Invalid lambda type!", e)
        }
    }
}