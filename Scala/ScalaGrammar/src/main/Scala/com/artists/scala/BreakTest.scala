package com.artists.scala

import scala.util.control.Breaks

object BreakTest {
  /**
   * There is no break & continue in scala, but after
   * v2.8 developers can use loop.break to implement it
   */
  def main(args: Array[String]): Unit = {
    Breaks.breakable(
      for (i: Int <- 1 to 10) {
        if(i == 5){
          Breaks.break()
        }
        println("Breaks test",i)
      }
    )

    val loop = new Breaks
    loop.breakable(
      for(i:Int <- 1 to 10){
        if(i == 5){
          loop.break()
        }
        println("Breaks test with create loop object",i)
      }
    )
  }

}
