package org.snakeskin.utility

import org.snakeskin.hardware.Hardware
import java.io.File
import java.io.OutputStream
import java.io.PrintWriter

/**
 * A Recorder is an object that records a series of data over time, and then writes it out to a file
 * or other stream.
 */
class Recorder(private val stream: OutputStream, val mode: RecordingMode) {
    enum class RecordingMode {
        CSV
    }

    private enum class SpecialMarkers(val title: String) {
        TIMESTAMP("Timestamp (s)")
    }

    companion object {
        /**
         * Creates a Recorder that records to a CSV file at the specified path
         * The final file will be: [path]/[name]-[current system time].csv
         */
        fun toCSV(path: String, name: String): Recorder {
            return Recorder(File("$path/$name-${Hardware.getAbsoluteTime()}.csv").outputStream(), RecordingMode.CSV)
        }
    }

    private val data = LinkedHashMap<Any, ArrayList<Any>>()
    private val columnTitles = hashMapOf<Any, String>(
            *SpecialMarkers.values().map { it to it.title }.toTypedArray()
    )
    private val createdAt = Hardware.getRelativeTime()

    /**
     * Records a new value
     */
    fun record(key: Any, value: Any) {
        if (!data.containsKey(key)) {
            data[key] = ArrayList()
        }
        data[key]?.add(value)
    }

    /**
     * Records the current timestamp, in seconds, since this object was created,
     * under the column name "Timestamp (s)"
     */
    fun recordTimestamp() {
        record(SpecialMarkers.TIMESTAMP, Hardware.getRelativeTime() - createdAt)
    }

    /**
     * Sets a custom column title.  Useful for adding units, etc.
     * This allows you to keep key names short while writing
     */
    fun setColumnTitle(key: Any, title: String) {
        columnTitles[key] = title
    }

    /**
     * Writes and closes this recorder.  After this is called,
     * this object should no longer be used
     */
    fun write() {
        when (mode) {
            RecordingMode.CSV -> {
                val printer = PrintWriter(stream)
                val biggestIndex = data.map { it.value.size }.max() ?: 0 //Find biggest index
                //Write header
                printer.println(data.map { columnTitles[it.key] ?: it.key }.joinToString())
                //Write data
                for (i in 0 until biggestIndex) {
                    printer.println(data.map { if (i < it.value.lastIndex) it.value[i].toString() else "" }.joinToString())
                }
                printer.flush()
                printer.close()
            }
        }
    }
}