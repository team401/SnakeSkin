[doc](../../index.md) / [org.snakeskin.logic](../index.md) / [ComparableDoubleHistory](./index.md)

# ComparableDoubleHistory

`class ComparableDoubleHistory : `[`History`](../-history/index.md)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>`

**Author**
Cameron Earle

**Version**
9/11/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ComparableDoubleHistory()` |

### Inherited Properties

| Name | Summary |
|---|---|
| [current](../-history/current.md) | `var current: `[`T`](../-history/index.md#T)`?` |
| [last](../-history/last.md) | `var last: `[`T`](../-history/index.md#T)`?` |

### Functions

| Name | Summary |
|---|---|
| [changedWithin](changed-within.md) | `fun changedWithin(deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [wentAbove](went-above.md) | `fun wentAbove(value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [wentBelow](went-below.md) | `fun wentBelow(value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [changed](../-history/changed.md) | `fun changed(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [update](../-history/update.md) | `open fun update(newValue: `[`T`](../-history/index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
