package com.artists.common

/**
 * sorted: sort the collection
 * sortBy(function): After execute function, sort the elements
 * sortWith: Input 2 values a and b, compare a and b and then
 * return result. e.g. a>b
 *
 */
object SortTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,9,2,8,3,7,4,6,5)
    val arr_2 = Array(("Allen",1),("Mic",2),("Lar",3))

    // sorted
    println("=== sorted ===")
    val res = arr.sorted
    res.foreach(x => print(x + " "))
    println("")
    val res_2 = arr_2.sorted
    res_2.foreach(x => print(x + " "))
    println("")

    /**
     * You can sort the collection as
     * Array(Array(1,2,3), Array(4,5,6))
     */

    // sortBy
    println("=== sortBy ===")
    val res_3 = arr.sortBy(x => x)
    res_3.foreach(x => print(x + " "))
    println("")
    val res_4 = arr.sortBy(x => x%2)
    res_4.foreach(x => print(x + " "))
    println("")
    val res_5 = arr.sortBy(x => -x)
    res_5.foreach(x => print(x + " "))
    println("")
    val res_6 = arr_2.sortBy(x => x._2)
    res_6.foreach(x => print(x + " "))
    println("")
    println("")

    // sortWith
    println("=== sortWith ===")
    val res_7 = arr.sortWith((a,b) => a>b)
    res_7.foreach(x => print(x + " "))
    println("")
  }
}
