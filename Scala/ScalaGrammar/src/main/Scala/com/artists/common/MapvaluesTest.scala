package com.artists.common

/**
 * 1. mapvalues -> deprecated at scala 2.13.10.
 * the collection must be map, can not be list, such as
 * List(("a",10),("b",20))
 * if use mapvalues,there will be an error
 * error: value mapvalues is not a memeber of List[(String, Int)]
 */
object MapvaluesTest {
  def main(args: Array[String]): Unit = {
    val map = Map("b" -> List(1,2,3), "a" -> List(4,5,6))
    val map_2 = Map(("zhangsan",20000),("lisi",30000),("wangwu",18000))

    // Demo_1
    println("Demo_1")
    map.mapValues(_.sum).foreach(t => println(t))
    println("")

    // Demo_2
    println("Demo_2")
    map_2.mapValues(t => t+1000).foreach(t => println(t))
    println("")
  }
}
