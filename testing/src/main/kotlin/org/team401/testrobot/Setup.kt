package org.team401.testrobot

import org.snakeskin.dsl.Setup

@Setup
fun setup() {
    println("Setup!")
    throw RuntimeException("Runtime exception!")
}