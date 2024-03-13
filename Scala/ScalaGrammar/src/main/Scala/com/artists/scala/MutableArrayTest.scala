package com.artists.scala

/**
 * 1. Initialization
 * 2. Common methods
 * 3. Type cast
 */
object MutableArrayTest {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.ArrayBuffer

    // 1. Initialization
    val buffer:ArrayBuffer[Int] = ArrayBuffer[Int](1,2,3,4,5)
    val buffer_2 = ArrayBuffer(1,2,3,4,5)
    val buffer_3 = new ArrayBuffer[Int]()

    // 2. Common methods

    // The original buffer will not change
    print(":+ : ")
    (buffer:+2).foreach((x) => {print(x + " ")})
    println()
    print("buffer : ")
    buffer.foreach((x) => {print(x + " ")})
    println()

    // The original buffer will change
    print("+= : ")
    (buffer+=1).foreach((x) => {print(x + " ")})
    println()
    print("buffer : ")
    buffer.foreach((x) => {print(x + " ")})
    println()
    print("-= : ")
    (buffer-=1).foreach((x) => {print(x + " ")})
    println()
    print("buffer : ")
    buffer.foreach((x) => {print(x + " ")})
    println()
    print("++= : ")
    (buffer++=Array(6,7,8)).foreach((x) => {print(x + " ")})
    println()
    print("buffer : ")
    buffer.foreach((x) => {print(x + " ")})
    println()
    print("++= : ")
    (buffer--=Array(6,7,8)).foreach((x) => {print(x + " ")})
    println()
    print("buffer : ")
    buffer.foreach((x) => {print(x + " ")})
    println()

    print("insert : ")
    buffer.insert(0,111)
    buffer.foreach((x) => {print(x + " ")})
    println()
    print("buffer : ")
    buffer.foreach((x) => {print(x + " ")})
    println()

    print("remove : ")
    buffer.remove(0)
    buffer.foreach((x) => {print(x + " ")})
    println()
    print("buffer : ")
    buffer.foreach((x) => {print(x + " ")})
    println()
    print("remove : ")
    buffer.remove(0,2)
    buffer.foreach((x) => {print(x + " ")})
    println()
    print("buffer : ")
    buffer.foreach((x) => {print(x + " ")})
    println()

    // 3. Type cast
    // From buffer to array
    val arr = buffer.toArray
    // From arr to buffer
    val buff_4 = arr.toBuffer
  }

}
