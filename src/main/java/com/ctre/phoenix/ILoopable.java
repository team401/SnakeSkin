package com.ctre.phoenix;
/*
 * snakeskin - Created on 12/1/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/1/17
 *
 * This interface is an exact replica of that found in CTRE's Phoenix library.
 * The purpose of this interface is to make it available to SnakeSkin's auto
 * system, without having to include an entire library.  It is excluded from
 * all compiled binaries, and will most likely be removed once Phoenix becomes
 * available on Maven
 */
public interface ILoopable {
    public void OnStart();
    public void OnLoop();
    public boolean IsDone();
    public void OnStop();
}
