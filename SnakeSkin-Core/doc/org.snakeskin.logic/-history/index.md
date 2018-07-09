[doc](../../index.md) / [org.snakeskin.logic](../index.md) / [History](./index.md)

# History

`open class History<T> : `[`AUpdatable`](../../org.snakeskin.ability/-a-updatable/index.md)`<`[`T`](index.md#T)`>`

**Author**
Cameron Earle

**Version**

7/18/17




A simple class that tracks history of an object

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `History()` |

### Properties

| Name | Summary |
|---|---|
| [current](current.md) | `var current: `[`T`](index.md#T)`?` |
| [last](last.md) | `var last: `[`T`](index.md#T)`?` |

### Functions

| Name | Summary |
|---|---|
| [changed](changed.md) | `fun changed(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [update](update.md) | `open fun update(newValue: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ComparableDoubleHistory](../-comparable-double-history/index.md) | `class ComparableDoubleHistory : `[`History`](./index.md)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>` |
