package com.artists.scala

/**
 * Cast A to B
 * 1.ListBuffer -> List
 * 2.ListBuffer -> ArrayBuffer
 * 3.ListBuffer -> Array
 * 4.ArrayBuffer- > List
 * 5. Array -> List
 * 6. Array -> Map
 * 7. List[Array[Any]] -> Map[String,Int]
 */
object ConversionTest {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.ListBuffer
    val list_buffer = ListBuffer(1, 2, 3)

    // 1.ListBuffer -> List
    val list = list_buffer.toList
    println("ListBuffer -> List: " + list.toString)

    // 2.ListBuffer -> ArrayBuffer
    val array_buffer = list_buffer.toBuffer
    println("ListBuffer -> ArrayBuffer: " + array_buffer.toString)

    // 3.ListBuffer -> Array
    val arr = list_buffer.toArray
    println("ListBuffer -> Array: " + arr.toString)

    // 4.ArrayBuffer- > List
    val list_2 = array_buffer.toList
    println("ArrayBuffer- > List: " + list_2.toString)

    // 5.Array -> List
    val list_3 = arr.toList
    println("Array -> List: " + list_3.toString)

    // 6.Array -> Map
    val arr_2 = Array("Allen","Mic")
    println("Array -> Map: " + arr_2.zip(arr).toMap.toString)

    // 7.List[Array[Any]] -> Map[String,Int]
    val list_exe = List(Array("Allen",1),Array("Mic",2))

    // 7.1 Method 1
    val list_0 = for(arr:Array[Any] <- list_exe) yield arr(0)
    val list_1 = for(arr:Array[Any] <- list_exe) yield arr(1)
    val map_0 = (list_0 zip list_1).toMap
    println("Res map_0: " + map_0.toString())

    // 7.2 Method 2
    val list_res = for(arr:Array[Any] <- list_exe) yield (arr(0),arr(1))
    val map_1 = list_res.toMap
    println("Res map_1: " + map_1.toString())

  }
}
