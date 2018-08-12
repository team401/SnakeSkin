package edu.wpi.first.wpilibj.hal

import java.nio.IntBuffer
import edu.wpi.first.wpilibj.AccumulatorResult


/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object AnalogJNI: JNIWrapper() {
    /**
     * *native declaration : AthenaJava\target\native\include\HAL\Analog.h:58*<br></br> enum values
     */
    interface AnalogTriggerType {
        companion object {
            /**
             * *native declaration : AthenaJava\target\native\include\HAL\Analog.h:54*
             */
            val kInWindow = 0
            /**
             * *native declaration : AthenaJava\target\native\include\HAL\Analog.h:55*
             */
            val kState = 1
            /**
             * *native declaration : AthenaJava\target\native\include\HAL\Analog.h:56*
             */
            val kRisingPulse = 2
            /**
             * *native declaration : AthenaJava\target\native\include\HAL\Analog.h:57*
             */
            val kFallingPulse = 3
        }
    }

    @JvmStatic fun initializeAnalogInputPort(halPortHandle: Int): Int {
        return halPortHandle
    }

    @JvmStatic fun freeAnalogInputPort(portHandle: Int) {}

    @JvmStatic fun initializeAnalogOutputPort(halPortHandle: Int): Int {
        return halPortHandle
    }

    @JvmStatic fun freeAnalogOutputPort(portHandle: Int) {}

    @JvmStatic fun checkAnalogModule(module: Byte): Boolean {
        return true
    }

    @JvmStatic fun checkAnalogInputChannel(channel: Int): Boolean {
        return true
    }

    @JvmStatic fun checkAnalogOutputChannel(channel: Int): Boolean {
        return true
    }

    @JvmStatic fun setAnalogOutput(portHandle: Int, voltage: Double) {
        //TODO add sim env

    }

    @JvmStatic fun getAnalogOutput(portHandle: Int): Double {
        //TODO add sim env
        return 0.0
    }

    @JvmStatic fun setAnalogSampleRate(samplesPerSecond: Double) {
        //TODO maybe let this be set?
    }

    @JvmStatic fun getAnalogSampleRate(): Double {
        return 1.0 / 25.0 //TODO if we let this be set make sure to use the stored value
    }

    @JvmStatic fun setAnalogAverageBits(analogPortHandle: Int, bits: Int) {
        //same as above
    }

    @JvmStatic fun getAnalogAverageBits(analogPortHandle: Int): Int {
        return 0
    }

    @JvmStatic fun setAnalogOversampleBits(analogPortHandle: Int, bits: Int) {

    }

    @JvmStatic fun getAnalogOversampleBits(analogPortHandle: Int): Int {
        return 0
    }

    //TODO below methods are no-op.  Need to be implemented in the sim env

    @JvmStatic fun getAnalogValue(analogPortHandle: Int): Short {
        return 0
    }

    @JvmStatic fun getAnalogAverageValue(analogPortHandle: Int): Int {
        return 0
    }

    @JvmStatic fun getAnalogVoltsToValue(analogPortHandle: Int, voltage: Double): Int {
        return 0
    }

    @JvmStatic fun getAnalogVoltage(analogPortHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getAnalogAverageVoltage(analogPortHandle: Int): Double {
        return 0.0
    }

    @JvmStatic fun getAnalogLSBWeight(analogPortHandle: Int): Int {
        return 0
    }

    @JvmStatic fun getAnalogOffset(analogPortHandle: Int): Int {
        return 0
    }

    @JvmStatic fun isAccumulatorChannel(analogPortHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun initAccumulator(analogPortHandle: Int) {

    }

    @JvmStatic fun resetAccumulator(analogPortHandle: Int) {

    }

    @JvmStatic fun setAccumulatorCenter(analogPortHandle: Int, center: Int) {

    }

    @JvmStatic fun setAccumulatorDeadband(analogPortHandle: Int, deadband: Int) {

    }


    @JvmStatic fun getAccumulatorValue(analogPortHandle: Int): Long {
        return 0
    }

    @JvmStatic fun getAccumulatorCount(analogPortHandle: Int): Int {
        return 0
    }

    @JvmStatic fun getAccumulatorOutput(analogPortHandle: Int, result: AccumulatorResult) {

    }

    @JvmStatic fun initializeAnalogTrigger(analogInputHandle: Int, index: IntBuffer): Int {
        return analogInputHandle
    }

    @JvmStatic fun cleanAnalogTrigger(analogTriggerHandle: Int) {}

    @JvmStatic fun setAnalogTriggerLimitsRaw(analogTriggerHandle: Int, lower: Int,
                                           upper: Int) {

    }

    @JvmStatic fun setAnalogTriggerLimitsVoltage(analogTriggerHandle: Int,
                                               lower: Double, upper: Double) {

    }

    @JvmStatic fun setAnalogTriggerAveraged(analogTriggerHandle: Int,
                                          useAveragedValue: Boolean) {

    }

    @JvmStatic fun setAnalogTriggerFiltered(analogTriggerHandle: Int,
                                          useFilteredValue: Boolean) {

    }

    @JvmStatic fun getAnalogTriggerInWindow(analogTriggerHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getAnalogTriggerTriggerState(analogTriggerHandle: Int): Boolean {
        return false
    }

    @JvmStatic fun getAnalogTriggerOutput(analogTriggerHandle: Int, type: Int): Boolean {
        return false
    }
}