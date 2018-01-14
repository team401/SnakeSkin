
# SnakeSkin: Team 401 Robot Framework
[![Travis](https://img.shields.io/travis/team401/SnakeSkin.svg)](https://travis-ci.org/team401/SnakeSkin)
[![Gitbook](https://cdn.rawgit.com/aleen42/badges/master/src/gitbook_2.svg)](https://team401.gitbooks.io/snakeskin/content/)
[![Language](https://img.shields.io/github/languages/top/team401/SnakeSkin.svg)](https://github.com/team401/SnakeSkin) 
[![license](https://img.shields.io/github/license/team401/SnakeSkin.svg)](https://github.com/team401/SnakeSkin/blob/master/LICENSE)

| Module  | Download  |
|---|---|
| Core  | [![Core](https://api.bintray.com/packages/team401/SnakeSkin/SnakeSkin-Core/images/download.svg) ](https://bintray.com/team401/SnakeSkin/SnakeSkin-Core/_latestVersion) |
| FRC | [![FRC](https://api.bintray.com/packages/team401/SnakeSkin/SnakeSkin-FRC/images/download.svg) ](https://bintray.com/team401/SnakeSkin/SnakeSkin-FRC/_latestVersion)  |
| CTRE  | [![CTRE](https://api.bintray.com/packages/team401/SnakeSkin/SnakeSkin-CTRE/images/download.svg) ](https://bintray.com/team401/SnakeSkin/SnakeSkin-CTRE/_latestVersion) |

SnakeSkin was our primary focus over the 2017 offseason.  SnakeSkin is a Kotlin framework that provides a [DSL](https://en.wikipedia.org/wiki/Domain-specific_language) to organize robot subsystems and components.  It consists of three modules (Core, FRC, and CTRE), allowing the user to pick only the components that they need.

SnakeSkin-Core is platform independent and provides most of the base functionality, including a state machine based subsystem model (based on 254's 2016 design), as well as many utility classes (such as a fully thread-safe PIDF controller, simple low pass filter, etc.)  

SnakeSkin-FRC provides the majority of features for an FRC robot, such as access to joysticks (several mappings created so far, as well as the ability to create your own), autonomous scheduling, and sensors.  

SnakeSkin-CTRE provides compatibility and drop-in replacements for CTRE’s Phoenix framework, including the “drivetrain model” for organizing motor controllers, and integrates with SnakeSkin’s auto executor.  

In terms of overhead, SnakeSkin has a very low impact (CPU usage for the user code process measured around 4% on an empty project).  SnakeSkin makes heavy use of the Java Executor framework to allow flexibly timed tasks to be executed reliably and concurrently.  While SnakeSkin is (we think, at least) stable for competition use, we do plan to add more features in the near future including better logging and power management.

The introductory [Gitbook](https://team401.gitbooks.io/snakeskin/content/) covers setup, subsystems, and state machines.
