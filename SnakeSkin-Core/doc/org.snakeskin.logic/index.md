[doc](../index.md) / [org.snakeskin.logic](./index.md)

## Package org.snakeskin.logic

### Types

| Name | Summary |
|---|---|
| [BooleanState](-boolean-state/index.md) | `open class BooleanState` |
| [ComparableDoubleHistory](-comparable-double-history/index.md) | `class ComparableDoubleHistory : `[`History`](-history/index.md)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>` |
| [Direction](-direction/index.md) | `object Direction` |
| [History](-history/index.md) | `open class History<T> : `[`AUpdatable`](../org.snakeskin.ability/-a-updatable/index.md)`<`[`T`](-history/index.md#T)`>` |
| [LockingDelegate](-locking-delegate/index.md) | `class LockingDelegate<T>` |
| [LowPass](-low-pass/index.md) | `open class LowPass` |
| [MutableParameters](-mutable-parameters/index.md) | `class MutableParameters` |
| [NullWaitable](-null-waitable/index.md) | `class NullWaitable : `[`AWaitable`](../org.snakeskin.ability/-a-waitable/index.md) |
| [PIDController](-p-i-d-controller/index.md) | `class PIDController : `[`AUpdatable`](../org.snakeskin.ability/-a-updatable/index.md)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>` |
| [PIDParameters](-p-i-d-parameters/index.md) | `class PIDParameters` |
| [Parameters](-parameters/index.md) | `class Parameters` |
| [Rotation2d](-rotation2d/index.md) | `class Rotation2d : `[`AInterpolatable`](../org.snakeskin.ability/-a-interpolatable/index.md)`<`[`Rotation2d`](-rotation2d/index.md)`>` |
| [Switch](-switch/index.md) | `interface Switch` |
| [TickedWaitable](-ticked-waitable/index.md) | `open class TickedWaitable : `[`AWaitable`](../org.snakeskin.ability/-a-waitable/index.md) |
| [TimedWaitable](-timed-waitable/index.md) | `class TimedWaitable : `[`TickedWaitable`](-ticked-waitable/index.md) |
| [Timer](-timer/index.md) | `class Timer` |
| [WaitableFuture](-waitable-future/index.md) | `class WaitableFuture : `[`AWaitable`](../org.snakeskin.ability/-a-waitable/index.md) |

### Functions

| Name | Summary |
|---|---|
| [Switch](-switch.md) | `fun Switch(boolFunc: () -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Switch`](-switch/index.md) |
