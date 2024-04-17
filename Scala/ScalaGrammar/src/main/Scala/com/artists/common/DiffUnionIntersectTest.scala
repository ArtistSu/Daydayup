package com.artists.common

/**
 * 1. intersect
 * 2. diff
 * 3. union
 */
object DiffUnionIntersectTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5)
    val arr_2 = Array(3,4,5,6,7)

    // Demo_1
    println("Demo_1")
    val res_1 = arr.intersect(arr_2)
    println("res_1: " + res_1.toList.toString())
    println("")

    // Demo_2
    println("Demo_2")
    val res_2 = arr.diff(arr_2)
    println("res_2: " + res_2.toList.toString())
    println("")

    // Demo_3
    println("Demo_3")
    val res_3 = arr.union(arr_2)
    println("res_3: " + res_3.toList.toString())
    println("")
  }
}
