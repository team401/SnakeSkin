package org.team401.snakeskin.publish

import edu.wpi.first.wpilibj.Sendable

/*
 * snakeskin - Created on 10/21/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 10/21/17
 */

typealias NumberPublisher = () -> Number
typealias DoublePublisher = () -> Double
typealias FloatPublisher = () -> Float
typealias IntPublisher = () -> Int
typealias LongPublisher = () -> Long
typealias ShortPublisher = () -> Short
typealias BytePublisher = () -> Byte
typealias BooleanPublisher = () -> Boolean
typealias StringPublisher = () -> String
typealias SendablePublisher = () -> Sendable