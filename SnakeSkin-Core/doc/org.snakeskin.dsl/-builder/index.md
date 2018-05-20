[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [Builder](./index.md)

# Builder

`interface Builder<out T>`

**Author**
Cameron Earle

**Version**
7/18/17

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `abstract fun build(): `[`T`](index.md#T) |

### Inheritors

| Name | Summary |
|---|---|
| [StateBuilder](../-state-builder/index.md) | `open class StateBuilder : `[`Builder`](./index.md)`<`[`State`](../../org.snakeskin.state/-state/index.md)`>`<br>Builds a State object |
| [StateMachineBuilder](../-state-machine-builder/index.md) | `class StateMachineBuilder : `[`Builder`](./index.md)`<`[`StateMachine`](../../org.snakeskin.state/-state-machine/index.md)`>` |
