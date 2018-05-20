[doc](../../index.md) / [org.snakeskin.state](../index.md) / [StateMachine](index.md) / [EMPTY_LAMBDA](./-e-m-p-t-y_-l-a-m-b-d-a.md)

# EMPTY_LAMBDA

`val EMPTY_LAMBDA: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

An shared reference to an empty lambda, which can be used as a default value to avoid running empty
tasks on the executor.  Checks should be made using the "===" in Kotlin to check reference equality

