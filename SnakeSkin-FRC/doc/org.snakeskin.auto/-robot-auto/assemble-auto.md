[doc](../../index.md) / [org.snakeskin.auto](../index.md) / [RobotAuto](index.md) / [assembleAuto](./assemble-auto.md)

# assembleAuto

`abstract fun assembleAuto(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Assembles the auto sequence.  This method must return before the auto sequence can be executed,
so it is important to do minimal processing in this method.  Process intensive tasks should be done
asynchronously or in the preAuto function.

