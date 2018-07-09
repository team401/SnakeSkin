[doc](../../index.md) / [org.snakeskin.auto](../index.md) / [RobotAuto](./index.md)

# RobotAuto

`abstract class RobotAuto : `[`AutoLoop`](../-auto-loop/index.md)

**Author**
Cameron Earle

**Version**

5/11/18




Defines an auto loop that has several conveniences for using on an FRC robot.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RobotAuto(rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 5L, preRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 100L)` |

### Properties

| Name | Summary |
|---|---|
| [preRate](pre-rate.md) | `val preRate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [rate](rate.md) | `open val rate: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

### Inherited Properties

| Name | Summary |
|---|---|
| [done](../-auto-loop/done.md) | `open var done: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `open fun action(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [add](add.md) | `fun add(step: `[`AutoStep`](../../org.snakeskin.auto.steps/-auto-step/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a single step to the sequence`fun add(steps: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`AutoStep`](../../org.snakeskin.auto.steps/-auto-step/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds an array of steps to the sequence`fun add(vararg steps: `[`AutoStep`](../../org.snakeskin.auto.steps/-auto-step/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the provided varargs to the sequence`fun add(steps: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`AutoStep`](../../org.snakeskin.auto.steps/-auto-step/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the provided collection to the sequence |
| [assembleAuto](assemble-auto.md) | `abstract fun assembleAuto(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Assembles the auto sequence.  This method must return before the auto sequence can be executed, so it is important to do minimal processing in this method.  Process intensive tasks should be done asynchronously or in the preAuto function. |
| [entry](entry.md) | `open fun entry(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [exit](exit.md) | `open fun exit(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [preAuto](pre-auto.md) | `open fun preAuto(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Runs certain tasks prior to auto's execution, at the rate defined by property "preRate" If the preRate is &lt;= 0, this function will not be called |
| [startTasks](start-tasks.md) | `open fun startTasks(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopTasks](stop-tasks.md) | `open fun stopTasks(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [tick](../-auto-loop/tick.md) | `fun tick(currentTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lastTime: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
