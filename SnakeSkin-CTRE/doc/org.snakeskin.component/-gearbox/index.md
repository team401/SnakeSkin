[doc](../../index.md) / [org.snakeskin.component](../index.md) / [Gearbox](./index.md)

# Gearbox

`class Gearbox`

**Author**
Cameron Earle

**Version**
12/25/17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Gearbox(master: IMotorControllerEnhanced, vararg slaves: IMotorController)` |

### Properties

| Name | Summary |
|---|---|
| [master](master.md) | `val master: IMotorControllerEnhanced` |
| [slaves](slaves.md) | `vararg val slaves: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out IMotorController>` |

### Functions

| Name | Summary |
|---|---|
| [enableVoltageCompensation](enable-voltage-compensation.md) | `fun enableVoltageCompensation(enable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getPosition](get-position.md) | `fun getPosition(pidIdx: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.PID_IDX): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getVelocity](get-velocity.md) | `fun getVelocity(pidIdx: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.PID_IDX): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [link](link.md) | `fun link(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Links the gearbox together, making all slaves follow the master |
| [set](set.md) | `fun set(mode: ControlMode, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setCurrentLimit](set-current-limit.md) | `fun setCurrentLimit(continuousCurrent: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, peakCurrent: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, peakDuration: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.CONFIG_TIMEOUT): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setInverted](set-inverted.md) | `fun setInverted(inverted: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = -1): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setNeutralMode](set-neutral-mode.md) | `fun setNeutralMode(mode: NeutralMode, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = -1): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setOutputLimits](set-output-limits.md) | `fun setOutputLimits(peakForward: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0, peakReverse: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0, nominalForward: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0, nominalReverse: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 1.0, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.CONFIG_TIMEOUT): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setPosition](set-position.md) | `fun setPosition(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, pidIdx: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.PID_IDX, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.CONFIG_TIMEOUT): ErrorCode` |
| [setRampRate](set-ramp-rate.md) | `fun setRampRate(closedLoop: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, openLoop: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.CONFIG_TIMEOUT): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setSensor](set-sensor.md) | `fun setSensor(sensor: FeedbackDevice, pidIdx: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.PID_IDX, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.CONFIG_TIMEOUT): ErrorCode`<br>`fun setSensor(sensor: RemoteFeedbackDevice, pidIdx: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.PID_IDX, timeout: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = CTREConstants.CONFIG_TIMEOUT): ErrorCode` |
| [setSensorPhase](set-sensor-phase.md) | `fun setSensorPhase(phase: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stop](stop.md) | `fun stop(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unlink](unlink.md) | `fun unlink(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Unlinks all motors, setting them to Percent VBus.  Useful for individual motor testing |
