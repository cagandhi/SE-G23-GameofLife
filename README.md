# SE-G23-HW2-3-GameofLife
[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.3998706.svg)](https://doi.org/10.5281/zenodo.3998706)
[![Build Status](https://travis-ci.org/cagandhi/SE-G23-GameofLife.svg?branch=master)](https://travis-ci.org/cagandhi/SE-G23-GameofLife)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Group 23 Software Engineering Fall 2020 Game of Life Repo for HW 2,3.

## Overview

+ This repo contains implementations for Conway's Game of Life in 3 languages: ```Julia, Scala and Kotlin``` where bugs have been planted at specific locations throughout the code. The tree representation for the repo is as follows:
```
code
   |
   |___ Julia
        |___ game_of_life.jl
        |___ README.md
   |___ Kotlin
        |___ GoL.kt
        |___ README.md
   |___ Scala
        |___ GameOfLife.scala
        |___ README.md
```

+ The instructions to run and debug code in each language can be found in the ```README.md``` inside each language's folder. For quick navigation, visit the below links:
  - [Julia ReadMe](code/Julia/README.md)
  - [Kotlin ReadMe](code/Kotlin/README.md)
  - [Scala ReadMe](code/Scala/README.md)

#### Logic for in-place implementation of game of life 
+ In Kotlin and Scala, we have implemented the game of life using an in-place logic. (i.e. without using a new matrix for next generation.) The logic is as follows:
+ As usual, live cell is represented by 1 and dead cell is represented by 0. But when a live cell becomes dead, we replace '1' with '-1' instead of '0'. Similarly, when a dead cell becomes alive, we replace '0' with '2' instead of '1'.
+ When we look for live or dead neighbors, we consider '-1' as live cell. (Because, it represents that the cell was live in previous genration but it will be dead in next generation). Similarly, we consider '2' as dead cell.
+ At the end of loop iteration (i.e. when all the cells are updated and we are ready to move towards next genertion), we replace all '-1' with '0' and all '2' with '1'.
+ For better understanding of this logic, see 'Approach 2' on [this page](https://leetcode.com/problems/game-of-life/solution/).

## Experimentation script (to guide the session)
[Code](code/) directory contains the GoL implementations which are almost similar in nature. Each code file contains 2 bugs: 1 compilation bug and 1 runtime bug. We ask you to identify and resolve these bugs from our life so we can live peacefully :)

As a subject in our experiment, we have listed the general steps you will need to follow for each language. Please share your screen with the moderator throughout the session which will aid us in analyzing your interactions with each of these languages.

* Visit the ReadMe files from the links provided in the above section.
* Follow the instructions in those ReadMe files and find the bugs in the implementations. If you are able to find both the bugs, you will see an output message that shows that compilation test has passed and if logical test is passing or failing.
* Once you have discovered the bugs for all 3 languages or the session is coming to an end, you will need to fill this google form: [https://forms.gle/ZBSEVTSdRgGMewXd9](https://forms.gle/ZBSEVTSdRgGMewXd9).

## Data collection tools

We leverage a google form filled by the subject and our manual observations to gather the data required to draw insights on. We use the subject's token to identify the subject's responses and do not ask for any personal details anywhere.

1. Google Form inputs

- __Programming languages familiar to the subject__: Measure how a subject's experience with a similar language aided the understanding of language L.
- __Time spent working with language L before the experiment__: Measure how bug solving effort changes with background experience of the subject in that language.
- __Time since language L was last used__: Measure if it was easier for the subject to solve bugs because they worked with language L recently.
- __Difficulty level of bugs introduced__: Even though we have tried to keep the difficulty level of bugs similar in the different languages' code, we want an input from the subject as to whether they felt any disparities in bug difficulty level among the 3 languages.
- __Quality of introduced bugs__: Qualitative input from the subject on the quality of the bugs.
- __Ranking the 3 languages based on ease of debugging__: Subject's ranking of the 3 languages based on how easy a language was to debug than another.
- __Ranking the 3 languages based on the interestingness measure__: Subject's ranking of the 3 languages based on how interesting they found a language to be.

2. Manual observations

- __Time taken to debug bugs in each language__: Direct measure of how easy it is to understand code in a language.
- __Number of bugs solved in each language__: Whether the subject was able to solve both the bugs in a language.
- __Number of times the code was run in the online compiler__: Measure of the ease of following the error stacktrace shown by the compiler.
- These manual observations will be recorded in [this google sheet](https://docs.google.com/spreadsheets/d/1mUfDjupsczMQOG7zdjMPwpimFpN12EN1l0mqjGJAVts/edit?usp=sharing).

## Team Members:
* Suraj Patel (sjpate22)
* Jay Modi (jmodi3)
* Omkar Kulkarni (oskulkar)
* Chintan Gandhi (cagandhi)
* Nirav Shah (nshah25)
