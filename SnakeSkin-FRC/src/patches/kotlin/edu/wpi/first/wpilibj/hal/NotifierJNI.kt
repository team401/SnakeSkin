package edu.wpi.first.wpilibj.hal

/**
 * @author Cameron Earle
 * @version 8/11/2018
 */
@Suppress("UNUSED_PARAMETER")
object NotifierJNI: JNIWrapper() {
    /**
     * Initializes the notifier.
     */
    @JvmStatic fun initializeNotifier(): Int {
        return 0
    }

    /**
     * Wakes up the waiter with time=0.  Note: after this function is called, all
     * calls to waitForNotifierAlarm() will immediately start returning 0.
     */
    @JvmStatic fun stopNotifier(notifierHandle: Int) {

    }

    /**
     * Deletes the notifier object when we are done with it.
     */
    @JvmStatic fun cleanNotifier(notifierHandle: Int) {

    }

    /**
     * Sets the notifier to wakeup the waiter in another triggerTime microseconds.
     */
    @JvmStatic fun updateNotifierAlarm(notifierHandle: Int, triggerTime: Long) {

    }

    /**
     * Cancels any pending wakeups set by updateNotifierAlarm().  Does NOT wake
     * up any waiters.
     */
    @JvmStatic fun cancelNotifierAlarm(notifierHandle: Int) {

    }

    /**
     * Block until woken up by an alarm (or stop).
     * @return Time when woken up.
     */
    @JvmStatic fun waitForNotifierAlarm(notifierHandle: Int): Long {
        return 0
    }
}