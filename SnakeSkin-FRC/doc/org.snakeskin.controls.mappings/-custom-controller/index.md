[doc](../../index.md) / [org.snakeskin.controls.mappings](../index.md) / [CustomController](./index.md)

# CustomController

`class CustomController : `[`Controller`](../../org.snakeskin.controls/-controller/index.md)

Created by cameronearle on 7/30/2017.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CustomController(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, numAxes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, numButtons: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, numHats: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)`<br>Created by cameronearle on 7/30/2017. |

### Properties

| Name | Summary |
|---|---|
| [Mapping](-mapping.md) | `val Mapping: `[`IMappingDefinitions`](../-i-mapping-definitions/index.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [addAxis](../../org.snakeskin.controls/-controller/add-axis.md) | `fun addAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, invert: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [addButton](../../org.snakeskin.controls/-controller/add-button.md) | `fun addButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [addHat](../../org.snakeskin.controls/-controller/add-hat.md) | `fun addHat(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getAxis](../../org.snakeskin.controls/-controller/get-axis.md) | `fun getAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Axis`](../../org.snakeskin.controls/-axis/index.md) |
| [getButton](../../org.snakeskin.controls/-controller/get-button.md) | `fun getButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Button`](../../org.snakeskin.controls/-button/index.md) |
| [getHat](../../org.snakeskin.controls/-controller/get-hat.md) | `fun getHat(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Hat`](../../org.snakeskin.controls/-hat/index.md) |
| [readAxis](../../org.snakeskin.controls/-controller/read-axis.md) | `fun readAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [readButton](../../org.snakeskin.controls/-controller/read-button.md) | `fun readButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [readHat](../../org.snakeskin.controls/-controller/read-hat.md) | `fun readHat(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [registerButtonPressListener](../../org.snakeskin.controls/-controller/register-button-press-listener.md) | `fun registerButtonPressListener(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerButtonReleaseListener](../../org.snakeskin.controls/-controller/register-button-release-listener.md) | `fun registerButtonReleaseListener(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerHatChangeListener](../../org.snakeskin.controls/-controller/register-hat-change-listener.md) | `fun registerHatChangeListener(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, action: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
