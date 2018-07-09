[doc](../../index.md) / [org.snakeskin.registry](../index.md) / [Registry](./index.md)

# Registry

`abstract class Registry<T>`

**Author**
Cameron Earle

**Version**
8/18/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Registry()` |

### Properties

| Name | Summary |
|---|---|
| [registry](registry.md) | `val registry: `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`T`](index.md#T)`>` |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(vararg items: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds items to the registry |

### Inheritors

| Name | Summary |
|---|---|
| [Subsystems](../-subsystems/index.md) | `object Subsystems : `[`Registry`](./index.md)`<`[`Subsystem`](../../org.snakeskin.subsystem/-subsystem/index.md)`>` |
