package com.artists.scala

object WhileTest {
  /**
   * 1. while
   * 2. do...while
   * 3. No break, continue keyword in scala
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {

    // while
    val times = 10
    var index = 5
    while (index < times) {
      println("good good study, day day up")
      index += 1
    }

    // do...while
    do {
      println("good good study, day day up_do_while")
    } while (index < times)

    // implement break
    index = 0
    var flag = true
    while (index < times & flag) {
      if (index == 5) {
        flag = false
      }
      index += 1
      println("good good study, day day up_break")
    }
  }
}
