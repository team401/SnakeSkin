[doc](../../index.md) / [org.snakeskin.rt](../index.md) / [RealTimeTask](./index.md)

# RealTimeTask

`interface RealTimeTask`

**Author**
Cameron Earle

**Version**

7/4/18




Implements a task that should be run in "real-time", meaning the rate at which it is called is continuous,
and the tasks inside are fixed time (or as close as possible).  Blocking should be avoided in real time tasks

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [action](action.md) | `abstract fun action(ctx: `[`RealTimeContext`](../-real-time-executor/-real-time-context/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
