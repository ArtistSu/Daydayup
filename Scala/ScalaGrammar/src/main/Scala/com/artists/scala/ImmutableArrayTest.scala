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
object ImmutableArrayTest {
  def main(args: Array[String]): Unit = {
    // 1.Array initialization
    val arr: Array[Int] = Array[Int](1, 2, 3, 4, 5, 6, 1)
    val arr_2 = Array(1, 2, 3, 4, 5, 6)
    val arr_3: Array[Int] = new Array[Int](5)
    val arr_4 = new Array[Unit](5)
    // The type is AnyVal
    val arr_5 = Array(1, 2, 3, true)
    // The type is Any
    val arr_6 = Array(1, 2, 3, "true")

    // 2.Get & Set
    println(arr(0))
    arr(0) = 100
    println("arr(0) is " + arr(0))

    // 3.Two-dimensional array
    val arr_7 = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8))
    val arr_8 = Array.ofDim[Int](4, 4)
    println("arr_7(0)(0) is " + arr_7(0)(0))
    arr_8(0)(0) = 100
    println("arr_8(0)(0) is " + arr_8(0)(0))

    // 4.Type cast
    // The type of following arr_9 is Array[Any]
    val arr_9 = Array(1, 2, 3, 4, Array(5, 6))
    println("5th element of arr_9 is " + arr_9(4).asInstanceOf[Array[Int]](1))

    // 5.Common methods
    println("length: " + arr.length)

    print("distinct: ")
    arr.distinct.foreach((x) => print(x + " "))
    println("")

    println("contains: " + arr.contains(100))

    println("head:" + arr.head)

    print("tail: ")
    arr.tail.foreach((x) => print(x + " "))
    println("")

    print("tail: ")
    arr.tail.tail.foreach((x) => print(x + " "))
    println("")

    println("indexOf: " + arr.indexOf(100))

    println("lastIndexOf: " + arr.lastIndexOf(1))

    println("max: " + arr.max)

    println("min: " + arr.min)

    println("mkString: " + arr.mkString("*"))

    print("reverse: ")
    arr.tail.tail.foreach((x) => print(x + " "))
    println("")

    println("size: " + arr.size)

    print("take 1: ")
    arr.take(1).foreach((x) => print(x + " "))
    println("")
    print("take 2: ")
    arr.take(2).foreach((x) => print(x + " "))
    println("")
    print("take 3: ")
    arr.take(3).foreach((x) => print(x + " "))
    println("")

    print("slice 1: ")
    arr.slice(0, 2).foreach((x) => print(x + " "))
    println("")
    print("slice 2: ")
    arr.slice(0, 3).foreach((x) => print(x + " "))
    println("")
    print("slice 3: ")
    arr.slice(1, 4).foreach((x) => print(x + " "))
    println("")

    // The arr will not change, +: or :+ will generate a new array
    print(":+ : ")
    (arr :+ 4).foreach((x) => print(x + " "))
    println("")
    print("arr: ")
    arr.foreach((x) => print(x + " "))
    println("")
    print("+: : ")
    (4 +: arr).foreach((x) => print(x + " "))
    println("")

    for (i <- arr) {
      print(i + " ")
    }
    println()
    arr.foreach((x) => {
      print(x + " ")
    })

    val arr_11 = Array("Allen", "Miche", "Lar")
    val arr_22 = Array(100, 200, 300)
    val com_arr = arr_11.zip(arr_22)
    for (i: (String, Int) <- com_arr) {
      println("zip i is " + i)
    }

    val com_arr2 = arr_11.zipWithIndex
    for (i: (String, Int) <- com_arr2) {
      println("zipWithIndex i is " + i)
    }
  }

  /**
   * Exercise: Define a method, the first parameter is Array[Int],
   * second parameter is number:Int. Please return the count of
   * the element in Array[Int] which smaller than the value of
   * number, equal to the number, and larger than the number.
   */
  def exercise1(arr: Array[Int], number: Int): (Int, Int, Int) = {
    var lgtcnt = 0
    var smtcnt = 0
    var eqtcnt = 0
    for (i <- arr) {
      if (i > number) {
        lgtcnt += 1
      } else if (i == number) {
        eqtcnt += 1
      } else {
        smtcnt += 1
      }
    }
    (smtcnt, eqtcnt, lgtcnt)
  }

  /**
   * Exercise2: Define a method with first parameter Array[Int],
   * please return the average of the sum of the max and min
   * value of this array and cast to double, the max value and
   * the min value in one time
   */
  def exercise2(arr: Array[Int]): (Int, Int, Double) = {
    (arr.max, arr.min, arr.sum * 1.0 / arr.length)
  }

  /**
   * Exercise3: Define a method, the first parameter is
   * Array(1,21,3,4,5,6,7,8) and return a string
   * "21 1 4 3 6 5 8 6"
   */
  def exercise3(arr: Array[Int]): String = {
    val arr1 = for(i<-0 until arr.length by 2) yield arr(i)
    val arr2 = for(i<-1 until arr.length by 2) yield arr(i)
    val arr3 = arr2.zip(arr1)
    val arr4 = for(tuple<-arr3) yield tuple._1+" "+tuple._2
    arr4.mkString(" ")
  }


}
