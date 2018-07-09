[doc](../../index.md) / [org.snakeskin.rt](../index.md) / [RealTimeExecutor](./index.md)

# RealTimeExecutor

`object RealTimeExecutor`

**Author**
Cameron Earle

**Version**

7/4/18




Uses a Notifier to run a list of real time tasks at a fixed rate.
Using the Notifier gives more precise timing than the system clock.

### Types

| Name | Summary |
|---|---|
| [RealTimeContext](-real-time-context/index.md) | `class RealTimeContext` |

### Properties

| Name | Summary |
|---|---|
| [rate](rate.md) | `var rate: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Rate, in seconds, that the RT executor should run at Defaults to 5ms |

### Functions

| Name | Summary |
|---|---|
| [addTask](add-task.md) | `fun addTask(task: `[`RealTimeTask`](../-real-time-task/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a real time task to the list of tasks to run |
| [getDt](get-dt.md) | `fun getDt(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Gets the most recent dt (seconds between last run and this one) value from the executor Useful for analysing how accurately the executor is maintaining the desired rate.  It should be very close to the rate property.  If not, something in your real time code is taking too long and should be removed. |
