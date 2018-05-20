[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [HumanControls](./index.md)

# HumanControls

`object HumanControls`

**Author**
Cameron Earle

**Version**
7/17/17

### Types

| Name | Summary |
|---|---|
| [Attack3Builder](-attack3-builder/index.md) | `class Attack3Builder : Builder<`[`Attack3`](../../org.snakeskin.controls.mappings/-attack3/index.md)`>, `[`ControlsBuilder`](-controls-builder/index.md) |
| [ButtonHandlerBuilder](-button-handler-builder/index.md) | `class ButtonHandlerBuilder` |
| [ControlsBuilder](-controls-builder/index.md) | `class ControlsBuilder` |
| [CustomBuilder](-custom-builder/index.md) | `class CustomBuilder : Builder<`[`CustomController`](../../org.snakeskin.controls.mappings/-custom-controller/index.md)`>, `[`ControlsBuilder`](-controls-builder/index.md) |
| [DualActionBuilder](-dual-action-builder/index.md) | `class DualActionBuilder : Builder<`[`DualAction`](../../org.snakeskin.controls.mappings/-dual-action/index.md)`>, `[`ControlsBuilder`](-controls-builder/index.md) |
| [Extreme3DBuilder](-extreme3-d-builder/index.md) | `class Extreme3DBuilder : Builder<`[`Extreme3D`](../../org.snakeskin.controls.mappings/-extreme3-d/index.md)`>, `[`ControlsBuilder`](-controls-builder/index.md) |
| [F310Builder](-f310-builder/index.md) | `class F310Builder : Builder<`[`F310`](../../org.snakeskin.controls.mappings/-f310/index.md)`>, `[`ControlsBuilder`](-controls-builder/index.md) |
| [GTWheelBuilder](-g-t-wheel-builder/index.md) | `class GTWheelBuilder : Builder<`[`GTWheel`](../../org.snakeskin.controls.mappings/-g-t-wheel/index.md)`>, `[`ControlsBuilder`](-controls-builder/index.md) |
| [SaitekButtonBoxBuilder](-saitek-button-box-builder/index.md) | `class SaitekButtonBoxBuilder : Builder<`[`SaitekButtonBox`](../../org.snakeskin.controls.mappings/-saitek-button-box/index.md)`>, `[`ControlsBuilder`](-controls-builder/index.md) |
| [T16000MBuilder](-t16000-m-builder/index.md) | `class T16000MBuilder : Builder<`[`T16000M`](../../org.snakeskin.controls.mappings/-t16000-m/index.md)`>, `[`ControlsBuilder`](-controls-builder/index.md) |

### Functions

| Name | Summary |
|---|---|
| [attack3](attack3.md) | `fun attack3(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`Attack3Builder`](-attack3-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Attack3`](../../org.snakeskin.controls.mappings/-attack3/index.md) |
| [custom](custom.md) | `fun custom(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, numAxes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, numButtons: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, numHats: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`CustomBuilder`](-custom-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`CustomController`](../../org.snakeskin.controls.mappings/-custom-controller/index.md) |
| [drivingForceGT](driving-force-g-t.md) | `fun drivingForceGT(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`GTWheelBuilder`](-g-t-wheel-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`GTWheel`](../../org.snakeskin.controls.mappings/-g-t-wheel/index.md) |
| [dualAction](dual-action.md) | `fun dualAction(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`DualActionBuilder`](-dual-action-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`DualAction`](../../org.snakeskin.controls.mappings/-dual-action/index.md) |
| [extreme3d](extreme3d.md) | `fun extreme3d(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`Extreme3DBuilder`](-extreme3-d-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Extreme3D`](../../org.snakeskin.controls.mappings/-extreme3-d/index.md) |
| [f310](f310.md) | `fun f310(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`F310Builder`](-f310-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`F310`](../../org.snakeskin.controls.mappings/-f310/index.md) |
| [saitekButtonBox](saitek-button-box.md) | `fun saitekButtonBox(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`SaitekButtonBoxBuilder`](-saitek-button-box-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`SaitekButtonBox`](../../org.snakeskin.controls.mappings/-saitek-button-box/index.md) |
| [t16000m](t16000m.md) | `fun t16000m(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`T16000MBuilder`](-t16000-m-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`T16000M`](../../org.snakeskin.controls.mappings/-t16000-m/index.md) |
