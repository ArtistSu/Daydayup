package com.artists.common

/**
 * Tip:
 *  tuple does not support flatten operation
 *
 * List(List(1,2), List(3,4)) —–> List(1,2,3,4)
 * List(Array(1,2),Array(3,4)) —–> List(1,2,3,4)
 * List(Map(“a”->1,“b”->2), Map(“c”->3,“d”->4)) –> List((a,1), (b,2), (c,3), (d,4))
 */
object FlattenTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(List(1,2),List(3,4))
    val arr_2 = Array(Array(arr,arr))
    val set = Set(1,2,3)
    val set_2 = Set(Set(1,2,3),Set(4,5,6))

    // Demo_1
    val arr_res = arr.flatten
    print("arr_res: ")
    arr_res.foreach(x => print(x + " "))
    println("")
    println("")

    /**
     * Demo_2
     * The following code will report error, cause by no implicit
     * view available from Any => Traversable[U]
     */
    //val arr_1 = Array(1,2,3,4, Array(5,6)).flatten

    // Demo_3 -> Please remember set is a distinct collection
    val set_res = Set(set,set).flatten
    print("set_res: ")
    println(set_res.toString())
    val set_res_2 = set_2.flatten
    print("set_res_2: ")
    println(set_res_2.toString())
    println("")

    /**
     * Demo_4
     * The following code will report an error, cause by value
     * flatten is not a member of xxxx
     * tuple does not support flatten operation
     */
    // val tuple_res = List((1,2),(3,4)).flatten

    // Demo_5
    // Array[Array[Array[List[Int]]]] -> Array[Array[List[Int]]]
    val arr_res_2 = arr_2.flatten
    // Array[Array[List[Int]]] -> Array[List[Int]]
    val arr_res_2_2 = arr_res_2.flatten
    // Array[List[Int]] -> Array[Int]
    val arr_res_2_3 = arr_res_2_2.flatten
    print("arr_res_2_3: ")
    arr_res_2_3.foreach(x => print(x +" "))

  }
}
