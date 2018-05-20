[doc](../../../index.md) / [org.snakeskin.dsl](../../index.md) / [HumanControls](../index.md) / [ControlsBuilder](./index.md)

# ControlsBuilder

`class ControlsBuilder`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ControlsBuilder(controller: `[`Controller`](../../../org.snakeskin.controls/-controller/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [deadbandAxis](deadband-axis.md) | `fun deadbandAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [invertAxis](invert-axis.md) | `fun invertAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [invertButton](invert-button.md) | `fun invertButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [scaleAxis](scale-axis.md) | `fun scaleAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, scaling: Scalar): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenButton](when-button.md) | `fun whenButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`ButtonHandlerBuilder`](../-button-handler-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenHatChanged](when-hat-changed.md) | `fun whenHatChanged(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, action: (newValue: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Attack3Builder](../-attack3-builder/index.md) | `class Attack3Builder : Builder<`[`Attack3`](../../../org.snakeskin.controls.mappings/-attack3/index.md)`>, `[`ControlsBuilder`](./index.md) |
| [CustomBuilder](../-custom-builder/index.md) | `class CustomBuilder : Builder<`[`CustomController`](../../../org.snakeskin.controls.mappings/-custom-controller/index.md)`>, `[`ControlsBuilder`](./index.md) |
| [DualActionBuilder](../-dual-action-builder/index.md) | `class DualActionBuilder : Builder<`[`DualAction`](../../../org.snakeskin.controls.mappings/-dual-action/index.md)`>, `[`ControlsBuilder`](./index.md) |
| [Extreme3DBuilder](../-extreme3-d-builder/index.md) | `class Extreme3DBuilder : Builder<`[`Extreme3D`](../../../org.snakeskin.controls.mappings/-extreme3-d/index.md)`>, `[`ControlsBuilder`](./index.md) |
| [F310Builder](../-f310-builder/index.md) | `class F310Builder : Builder<`[`F310`](../../../org.snakeskin.controls.mappings/-f310/index.md)`>, `[`ControlsBuilder`](./index.md) |
| [GTWheelBuilder](../-g-t-wheel-builder/index.md) | `class GTWheelBuilder : Builder<`[`GTWheel`](../../../org.snakeskin.controls.mappings/-g-t-wheel/index.md)`>, `[`ControlsBuilder`](./index.md) |
| [SaitekButtonBoxBuilder](../-saitek-button-box-builder/index.md) | `class SaitekButtonBoxBuilder : Builder<`[`SaitekButtonBox`](../../../org.snakeskin.controls.mappings/-saitek-button-box/index.md)`>, `[`ControlsBuilder`](./index.md) |
| [T16000MBuilder](../-t16000-m-builder/index.md) | `class T16000MBuilder : Builder<`[`T16000M`](../../../org.snakeskin.controls.mappings/-t16000-m/index.md)`>, `[`ControlsBuilder`](./index.md) |
