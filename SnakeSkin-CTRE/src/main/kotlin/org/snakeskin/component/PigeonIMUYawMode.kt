package org.snakeskin.component

/**
 * Represents modes for acquiring the yaw from a Pigeon IMU
 */
enum class PigeonIMUYawMode {
    /**
     * Fused heading fuses the compass and the gyro for an accurate measurement.  The compass must be calibrated
     * for an accurate measurement.
     */
    FUSED,

    /**
     * Gyro heading only uses the gyro sensor to acquire the yaw, and thus is prone to drift over long periods
     */
    GYRO
}