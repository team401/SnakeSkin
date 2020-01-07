package org.snakeskin.rt

/**
 * Where to insert a real time task in the task list for an executor
 */
enum class TaskRegistrationOrder {
    /**
     * HEAD inserts the task either at the beginning of the list, or directly after the last HEAD task in the list
     */
    HEAD,

    /**
     * DEFAULT inserts the task either after the last HEAD task, or after the last DEFAULT task in the list
     */
    DEFAULT,

    /**
     * TAIL inserts the task either after the last TAIL task, or after the last DEFAULT task in the list
     */
    TAIL
}