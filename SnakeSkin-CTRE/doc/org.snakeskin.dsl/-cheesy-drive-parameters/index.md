[doc](../../index.md) / [org.snakeskin.dsl](../index.md) / [CheesyDriveParameters](./index.md)

# CheesyDriveParameters

`data class CheesyDriveParameters`

Implements the Cheesy Poofs "Cheesy Drive" for a SnakeSkin drivetrain

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CheesyDriveParameters(highWheelNonLinearity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lowWheelNonLinearity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, highNegInertiaScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lowNegInertiaThreshold: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lowNegInertiaTurnScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lowNegInertiaCloseScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lowNegInertiaFarScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, highSensitivity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lowSensitivity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, quickStopDeadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, quickStopWeight: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, quickStopScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lowSinCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, highSinCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, outputScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0, quickTurnScalar: Scalar = NoScaling)`<br>Implements the Cheesy Poofs "Cheesy Drive" for a SnakeSkin drivetrain |

### Properties

| Name | Summary |
|---|---|
| [highDenom](high-denom.md) | `val highDenom: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [highNegInertiaScalar](high-neg-inertia-scalar.md) | `val highNegInertiaScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [highSensitivity](high-sensitivity.md) | `val highSensitivity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [highSinCount](high-sin-count.md) | `val highSinCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [highWheelNonLinearity](high-wheel-non-linearity.md) | `val highWheelNonLinearity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [lowDenom](low-denom.md) | `val lowDenom: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [lowNegInertiaCloseScalar](low-neg-inertia-close-scalar.md) | `val lowNegInertiaCloseScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [lowNegInertiaFarScalar](low-neg-inertia-far-scalar.md) | `val lowNegInertiaFarScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [lowNegInertiaThreshold](low-neg-inertia-threshold.md) | `val lowNegInertiaThreshold: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [lowNegInertiaTurnScalar](low-neg-inertia-turn-scalar.md) | `val lowNegInertiaTurnScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [lowSensitivity](low-sensitivity.md) | `val lowSensitivity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [lowSinCount](low-sin-count.md) | `val lowSinCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [lowWheelNonLinearity](low-wheel-non-linearity.md) | `val lowWheelNonLinearity: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [negInertiaAccumulator](neg-inertia-accumulator.md) | `var negInertiaAccumulator: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [oldWheel](old-wheel.md) | `var oldWheel: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [outputScalar](output-scalar.md) | `val outputScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [quickStopAccumulator](quick-stop-accumulator.md) | `var quickStopAccumulator: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [quickStopDeadband](quick-stop-deadband.md) | `val quickStopDeadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [quickStopScalar](quick-stop-scalar.md) | `val quickStopScalar: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [quickStopWeight](quick-stop-weight.md) | `val quickStopWeight: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [quickTurnScalar](quick-turn-scalar.md) | `val quickTurnScalar: Scalar` |

### Functions

| Name | Summary |
|---|---|
| [reset](reset.md) | `fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
