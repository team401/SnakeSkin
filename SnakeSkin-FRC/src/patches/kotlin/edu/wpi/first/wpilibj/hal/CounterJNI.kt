package edu.wpi.first.wpilibj.hal

import java.nio.IntBuffer

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object CounterJNI: JNIWrapper() {
    @JvmStatic fun initializeCounter(mode: Int, index: IntBuffer): Int {
        return index.get()
    }

    @JvmStatic fun freeCounter(counterHandle: Int) {}

    @JvmStatic fun setCounterAverageSize(counterHandle: Int, size: Int) {

    }

    @JvmStatic fun setCounterUpSource(counterHandle: Int, digitalSourceHandle: Int,
                                    analogTriggerType: Int) {

    }

    @JvmStatic fun setCounterUpSourceEdge(counterHandle: Int, risingEdge: Boolean,
                                        fallingEdge: Boolean) {

    }

    @JvmStatic fun clearCounterUpSource(counterHandle: Int) {

    }

    @JvmStatic fun setCounterDownSource(counterHandle: Int, digitalSourceHandle: Int,
                                      analogTriggerType: Int) {

    }

    @JvmStatic fun setCounterDownSourceEdge(counterHandle: Int, risingEdge: Boolean,
                                          fallingEdge: Boolean) {

    }

    @JvmStatic fun clearCounterDownSource(counterHandle: Int) {

    }

    @JvmStatic fun setCounterUpDownMode(counterHandle: Int) {

    }

    @JvmStatic fun setCounterExternalDirectionMode(counterHandle: Int) {

    }

    @JvmStatic fun setCounterSemiPeriodMode(counterHandle: Int,
                                          highSemiPeriod: Boolean) {

    }

    @JvmStatic fun setCounterPulseLengthMode(counterHandle: Int, threshold: Double) {

    }

    @JvmStatic fun getCounterSamplesToAverage(counterHandle: Int): Int {
        return 0
    }

    @JvmStatic fun setCounterSamplesToAverage(counterHandle: Int,
                                            samplesToAverage: Int) {

    }

    @JvmStatic fun resetCounter(counterHandle: Int) {}

    @JvmStatic fun getCounter(counterHandle: Int): Int {
        return 0
    }

    @JvmStatic fun getCounterPeriod(counterHandle: Int): Double {
        return 1.0
    }

    @JvmStatic fun setCounterMaxPeriod(counterHandle: Int, maxPeriod: Double) {

    }

    @JvmStatic fun setCounterUpdateWhenEmpty(counterHandle: Int, enabled: Boolean) {

    }

    @JvmStatic fun getCounterStopped(counterHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getCounterDirection(counterHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun setCounterReverseDirection(counterHandle: Int,
                                            reverseDirection: Boolean) {

    }
}