[doc](../../index.md) / [org.snakeskin.component](../index.md) / [Piston](./index.md)

# Piston

`class Piston : AInvertable, AToggleable`

**Author**
Cameron Earle

**Version**
8/17/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Piston(port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, pcm: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, extensionTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0, retractionTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0)` |

### Properties

| Name | Summary |
|---|---|
| [extensionTime](extension-time.md) | `val extensionTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [inverted](inverted.md) | `var inverted: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [pcm](pcm.md) | `val pcm: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [port](port.md) | `val port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [retractionTime](retraction-time.md) | `val retractionTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |

### Functions

| Name | Summary |
|---|---|
| [extend](extend.md) | `fun extend(): AWaitable` |
| [retract](retract.md) | `fun retract(): AWaitable` |
| [toggle](toggle.md) | `fun toggle(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
