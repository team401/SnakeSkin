[doc](../../index.md) / [org.snakeskin.sensors](../index.md) / [InterruptableGyro](./index.md)

# InterruptableGyro

`interface InterruptableGyro : Gyro`

**Author**
Zachary Kozar

**Version**

5/22/17




A gyro with more precise controls on calibration.

### Functions

| Name | Summary |
|---|---|
| [cancelCalibrate](cancel-calibrate.md) | `abstract fun cancelCalibrate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [endCalibrate](end-calibrate.md) | `abstract fun endCalibrate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getCalibrationSampleTime](get-calibration-sample-time.md) | `abstract fun getCalibrationSampleTime(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [getCenter](get-center.md) | `abstract fun getCenter(): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [startCalibrate](start-calibrate.md) | `abstract fun startCalibrate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [getAngleAsRotation](../../org.snakeskin.dsl/edu.wpi.first.wpilibj.interfaces.-gyro/get-angle-as-rotation.md) | `fun Gyro.getAngleAsRotation(): Rotation2d` |
