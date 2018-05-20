[doc](../../index.md) / [org.snakeskin.controls](../index.md) / [Controller](./index.md)

# Controller

`abstract class Controller`

**Author**
Cameron Earle

**Version**
7/16/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Controller(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [Mapping](-mapping.md) | `abstract val Mapping: `[`IMappingDefinitions`](../../org.snakeskin.controls.mappings/-i-mapping-definitions/index.md) |

### Functions

| Name | Summary |
|---|---|
| [addAxis](add-axis.md) | `fun addAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, invert: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [addButton](add-button.md) | `fun addButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [addHat](add-hat.md) | `fun addHat(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getAxis](get-axis.md) | `fun getAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Axis`](../-axis/index.md) |
| [getButton](get-button.md) | `fun getButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Button`](../-button/index.md) |
| [getHat](get-hat.md) | `fun getHat(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Hat`](../-hat/index.md) |
| [readAxis](read-axis.md) | `fun readAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [readButton](read-button.md) | `fun readButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [readHat](read-hat.md) | `fun readHat(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [registerButtonPressListener](register-button-press-listener.md) | `fun registerButtonPressListener(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerButtonReleaseListener](register-button-release-listener.md) | `fun registerButtonReleaseListener(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, action: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerHatChangeListener](register-hat-change-listener.md) | `fun registerHatChangeListener(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, action: (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Attack3](../../org.snakeskin.controls.mappings/-attack3/index.md) | `class Attack3 : `[`Controller`](./index.md)<br>Created by cameronearle on 8/4/2017. |
| [CustomController](../../org.snakeskin.controls.mappings/-custom-controller/index.md) | `class CustomController : `[`Controller`](./index.md)<br>Created by cameronearle on 7/30/2017. |
| [DualAction](../../org.snakeskin.controls.mappings/-dual-action/index.md) | `class DualAction : `[`Controller`](./index.md) |
| [Extreme3D](../../org.snakeskin.controls.mappings/-extreme3-d/index.md) | `class Extreme3D : `[`Controller`](./index.md) |
| [F310](../../org.snakeskin.controls.mappings/-f310/index.md) | `class F310 : `[`Controller`](./index.md) |
| [GTWheel](../../org.snakeskin.controls.mappings/-g-t-wheel/index.md) | `class GTWheel : `[`Controller`](./index.md)<br>Created by cameronearle on 7/28/2017. |
| [SaitekButtonBox](../../org.snakeskin.controls.mappings/-saitek-button-box/index.md) | `class SaitekButtonBox : `[`Controller`](./index.md) |
| [T16000M](../../org.snakeskin.controls.mappings/-t16000-m/index.md) | `class T16000M : `[`Controller`](./index.md) |
