package com.artists.scala

/**
 * Cast A to B
 * 1.ListBuffer -> List
 * 2.ListBuffer -> ArrayBuffer
 * 3.ListBuffer -> Array
 * 4.ArrayBuffer- > List
 * 5. Array -> List
 */
object ConversionTest {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.ListBuffer
    val list_buffer = ListBuffer(1, 2, 3)

    // 1.ListBuffer -> List
    val list = list_buffer.toList

    // 2.ListBuffer -> ArrayBuffer
    val array_buffer = list_buffer.toBuffer

    // 3.ListBuffer -> Array
    val arr = list_buffer.toArray

    // 4.ArrayBuffer- > List
    val list_2 = array_buffer.toList

    // 5. Array -> List
    val list_3 = arr.toList
  }
}
