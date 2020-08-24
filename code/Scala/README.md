Steps to Run code for Scala:

1. Go to [https://scastie.scala-lang.org/](https://scastie.scala-lang.org/).
2. Copy and paste the code: ```GameOfLife.scala```
3. Press ```Save``` button to view the output in the terminal pop-up.

How to debug?
1. Use ```println("<your text>")``` to print your debug statements.
2. Use ```s"<your text>"``` and ```${<variable name>}``` inside ```println()``` to evaluate expressions.
+ Example:
  - ```var i = 3```
  - ```println(s"Value of i: ${i}")``` --> Value of i: 3
  - ```println(s"Double of i: ${i*2}")``` --> Double of i: 6
