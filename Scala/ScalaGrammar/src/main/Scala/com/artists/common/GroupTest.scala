package com.artists.common

/**
 * 1. groupBy
 * 2. grouped
 */
object GroupTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arr_2= Array("hello","hehe","world","hahah","what","kitty","kill","zoo","zookeeper")
    val arr_3 = Array(("zhangsan",100),("lisi",98),("wangwu",45),("zhaosi",36))

    // Demo_1
    println("Demo_1")
    val res_1 = arr.groupBy(t => if (t % 2 == 0) "even" else "odd")
    for (k <- res_1.keySet) {
      print(s"Key:${k}, Value:")
      res_1(k).foreach(x => print(x + " "))
      println("")
    }

    // Demo_2
    println("")
    println("Demo_2")
    val res_2 = arr.groupBy(t => t % 2 == 0)
    for (k <- res_2.keySet) {
      print(s"Key:${k}, Value:")
      res_2(k).foreach(x => print(x + " "))
      println("")
    }

    // Demo_3
    println("")
    println("Demo_3")
    val res_3 = arr_2.groupBy(t => t.startsWith("z"))
    for (k <- res_3.keySet) {
      print(s"Key:${k}, Value:")
      res_3(k).foreach(x => print(x + " "))
      println("")
    }

    // Demo_4
    println("")
    println("Demo_4")
    val res_4 = arr_2.groupBy(t => t.substring(0,1))
    for (k <- res_4.keySet) {
      print(s"Key:${k}, Value:")
      res_4(k).foreach(x => print(x + " "))
      println("")
    }

    // Demo_5
    println("")
    println("Demo_5")
    val res_5 = arr_3.groupBy(t => t._2 >= 60)
    for (k <- res_5.keySet) {
      print(s"Key:${k}, Value:")
      res_5(k).foreach(x => print("("+x._1 + "," + x._2+") "))
      println("")
    }

    /**
     * 2. grouped
     */
    println("")
    println("Demo_1")
    arr.grouped(3).foreach(t => println(t.toList))

    println("")
    println("Demo_2")
    arr.grouped(2).map(t => t.reverse).foreach(t => println(t.toList))

    println("")
    println("Demo_3")
    val res_8 = arr.grouped(2).map(t => t.reverse).flatten.mkString(" ")
    println(res_8)
  }
}
