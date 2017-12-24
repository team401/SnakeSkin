package org.snakeskin.auto

open class LambdaAutoStep(var entry: () -> Unit = Auto.EMPTY_LAMBDA,
                          var action: () -> Unit = Auto.EMPTY_LAMBDA,
                          var exit: () -> Unit = Auto.EMPTY_LAMBDA): AutoStep() {

    init {
        if (action === Auto.EMPTY_LAMBDA) {
            action = {done = true}
        }
    }
}