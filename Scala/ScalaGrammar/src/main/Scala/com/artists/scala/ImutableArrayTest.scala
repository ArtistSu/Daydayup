package com.artists.scala

import scala.Int.int2double

/**
 * Array is mutable, indexable, collection of elements of the
 * same type. The array can has the fixed length and unfixed length.
 * If you want to create unfixed length array, you should import
 * thirty-party jar.
 * 1. Array initialization
 * 2. Get & set value
 * 3. Two-dimensional array
 * 4. Type cast
 * 5. Common methods
 */
object ImutableArrayTest {
  def main(args: Array[String]): Unit = {
    // Array initialization
    val arr:Array[Int] = Array[Int](1,2,3,4,5,6,1)
    val arr_2 = Array(1,2,3,4,5,6)
    val arr_3:Array[Int] = new Array[Int](5)
    val arr_4 = new Array[Unit](5)
    // The type is AnyVal
    val arr_5 = Array(1,2,3,true)
    // The type is Any
    val arr_6 = Array(1,2,3,"true")

    // Get & Set
    println(arr(0))
    arr(0) = 100
    println("arr(0) is " + arr(0))

    // Two-dimensional array
    val arr_7 = Array(Array(1,2,3,4),Array(5,6,7,8))
    val arr_8 = Array.ofDim[Int](4,4)
    println("arr_7(0)(0) is " + arr_7(0)(0))
    arr_8(0)(0) = 100
    println("arr_8(0)(0) is " + arr_8(0)(0))

    // Type cast
    // The type of following arr_9 is Array[Any]
    val arr_9 = Array(1,2,3,4,Array(5,6))
    println("5th element of arr_9 is " + arr_9(4).asInstanceOf[Array[Int]](1))

    // Common methods
    println("length: " + arr.length)

    print("distinct: ")
    arr.distinct.foreach((x)=> print(x + " "))
    println("")

    println("contains: " + arr.contains(100))

    println("head:" + arr.head)

    print("tail: ")
    arr.tail.foreach((x)=> print(x + " "))
    println("")

    print("tail: ")
    arr.tail.tail.foreach((x)=> print(x + " "))
    println("")

    println("indexOf: " + arr.indexOf(100))

    println("lastIndexOf: " + arr.lastIndexOf(1))

    println("max: " + arr.max)

    println("min: " + arr.min)

    println("mkString: " + arr.mkString("*"))

    print("reverse: ")
    arr.tail.tail.foreach((x)=> print(x + " "))
    println("")

    println("size: " + arr.size)

    print("take 1: ")
    arr.take(1).foreach((x)=> print(x + " "))
    println("")
    print("take 2: ")
    arr.take(2).foreach((x)=> print(x + " "))
    println("")
    print("take 3: ")
    arr.take(3).foreach((x)=> print(x + " "))
    println("")

    print("slice 1: ")
    arr.slice(0,2).foreach((x)=> print(x + " "))
    println("")
    print("slice 2: ")
    arr.slice(0,3).foreach((x)=> print(x + " "))
    println("")
    print("slice 3: ")
    arr.slice(1,4).foreach((x)=> print(x + " "))
    println("")

    // The arr will not change, +: or :+ will generate a new array
    print(":+ : ")
    (arr:+4).foreach((x)=> print(x + " "))
    println("")
    print("arr: ")
    arr.foreach((x)=> print(x + " "))
    println("")
    print("+: : ")
    (4+:arr).foreach((x)=> print(x + " "))
    println("")

    for(i<-arr){
      print(i + " ")
    }
    println()
    arr.foreach((x)=>{print(x + " ")})


  }

}
