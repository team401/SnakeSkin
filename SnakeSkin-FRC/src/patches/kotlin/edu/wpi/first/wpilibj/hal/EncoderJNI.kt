package edu.wpi.first.wpilibj.hal

import java.nio.IntBuffer

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object EncoderJNI: JNIWrapper() {
    @JvmStatic fun initializeEncoder(digitalSourceHandleA: Int, analogTriggerTypeA: Int,
                                   digitalSourceHandleB: Int, analogTriggerTypeB: Int,
                                   reverseDirection: Boolean, encodingType: Int): Int {
        val ib = IntBuffer.allocate(4)
        ib.put(digitalSourceHandleA)
        ib.put(digitalSourceHandleB)
        return ib.get()
    }

    @JvmStatic fun freeEncoder(encoderHandle: Int) {}

    @JvmStatic fun getEncoder(encoderHandle: Int): Int {
        return 0
    }

    @JvmStatic fun getEncoderRaw(encoderHandle: Int): Int {
        return 0
    }

    @JvmStatic fun getEncodingScaleFactor(encoderHandle: Int): Int {
        return 0
    }

    @JvmStatic fun resetEncoder(encoderHandle: Int) {}

    @JvmStatic fun getEncoderPeriod(encoderHandle: Int): Double {
        return 1.0
    }

    @JvmStatic fun setEncoderMaxPeriod(encoderHandle: Int, maxPeriod: Double) {

    }

    @JvmStatic fun getEncoderStopped(encoderHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getEncoderDirection(encoderHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getEncoderDistance(encoderHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getEncoderRate(encoderHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun setEncoderMinRate(encoderHandle: Int, minRate: Double) {

    }

    @JvmStatic fun setEncoderDistancePerPulse(encoderHandle: Int, distancePerPulse: Double) {

    }

    @JvmStatic fun setEncoderReverseDirection(encoderHandle: Int,
                                            reverseDirection: Boolean) {

    }

    @JvmStatic fun setEncoderSamplesToAverage(encoderHandle: Int,
                                            samplesToAverage: Int) {

    }

    @JvmStatic fun getEncoderSamplesToAverage(encoderHandle: Int): Int {
        return 1
    }

    @JvmStatic fun setEncoderIndexSource(encoderHandle: Int, digitalSourceHandle: Int,
                                       analogTriggerType: Int, indexingType: Int) {

    }

    @JvmStatic fun getEncoderFPGAIndex(encoderHandle: Int): Int {
        return 0
    }

    @JvmStatic fun getEncoderEncodingScale(encoderHandle: Int): Int {
        return 0
    }

    @JvmStatic fun getEncoderDecodingScaleFactor(encoderHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getEncoderDistancePerPulse(encoderHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getEncoderEncodingType(encoderHandle: Int): Int {
        return 0
    }
}