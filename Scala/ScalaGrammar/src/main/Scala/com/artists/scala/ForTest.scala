package com.artists.scala

object ForTest {
  /**
   * 1. for -> only enhance for loop in scala
   * 2. to
   * 3. until
   * 4. nested for loop
   * 5. Parallel for loop
   * 6. guard for loop
   */
  def main(args: Array[String]): Unit = {
    // enhance for loop
    val arr = Array(11, 22, 33, 44)
    for (i: Int <- arr) {
      printf("i is %s \n", i)
    }

    // to -> include 1 and 10
    for (i: Int <- 1 to 10) {
      printf("to: i is %s \n", i)
    }

    for (i: Int <- 1 to(10, 2)) {
      printf("to_step2: i is %s \n", i)
    }

    for (i: Int <- 1 to 10 by 2) {
      printf("to_by2: i is %s \n", i)
    }

    // until -> include 1 but not include 10
    for (i: Int <- 1 until 10) {
      printf("until: i is %s \n", i)
    }

    // nested for loop
    for (i: Int <- 1 to 10) {
      for (j: Int <- 1 to i) {
        print(i + "*" + j + " = " + (i * j) + " ")
      }
      println()
    }

    // parallel for loop
    for (i: Int <- 1 to 10; j: Int <- 1 to i) {
      println(i, "*", j, "=", i * j)
    }

    // guard for loop
    for(i:Int <- 1 to 10 if (i % 2 == 0)){
      println("guard for loop ", i)
    }
  }
}
