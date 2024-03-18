package com.artists.common

/**
 * 1. filter
 * 2. filterNot
 */
object FilterTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5,6,7,8,9)
    val arr_2 = Array(("Allen",Array(100,60,90)), ("Mic",Array(40,80,95)))

    // filter - Demo 1
    val arr_res = arr.filter(x => if(x>5) true else false)
    arr_res.foreach(x => print(x+" "))
    println("")
    println("")

    // filter- Demo 2
    val arr_res_2 = arr_2.map(x => (x._1,x._2.filter(y => y>=60).size))
    arr_res_2.foreach(x => println(x._1+","+x._2))
    println("")

    // filterNot - Demo 1
    val arr_res_3 = arr.filterNot(x => x % 2 == 0)
    arr_res_3.foreach(x => print(x + " "))
  }
}
