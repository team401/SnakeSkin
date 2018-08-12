package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
object ThreadsJNI: JNIWrapper() {
    @JvmStatic fun getCurrentThreadPriority(): Int {
        return 0
    }

    @JvmStatic fun getCurrentThreadIsRealTime(): Boolean {
        return false
    }

    @JvmStatic fun setCurrentThreadPriority(realTime: Boolean, priority: Int): Boolean {
        return true
    }
}