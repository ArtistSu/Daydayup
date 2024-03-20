package com.artists.common
import scala.collection.parallel.CollectionConverters._

/**
 * fold: This is a reduce() with an initial value.
 * foldLeft: This is a reduceLeft() with an initial value.
 * foldRight: This is a reduceRight() with an initial value.
 *
 * foldLeft, foldRight => can't run in multi-thread
 */
object FoldTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    val arr_2 = Array(("Allen", 1), ("Mic", 2))
    val arr_3 = Array(1)
    val list = List(1,2,3,4,5)

    // Demo_1
    println("Res_1: " + arr.fold(10)((a, b) => {
      println(s"a:$a --- b: $b")
      a + b
    }))

    // Demo_2
    println("Res_2: " + arr_2.fold("", 0)((a, b) => (a._1 + "-" + b._1, a._2 + b._2)))

    // Demo_3
    println("Res_3: " + arr_3.fold(10)((a, b) => a + b))

    // Demo_4
    /**
     * Why the result is different. You can see the source code of fold. When you array is not
     * empty, it will return the last element in your array as the initial value. If the array
     * is null, it will use z as the initial value. Base on the following code it should be 10.
     *
     * if (f$mIc$sp$3_length < 0) {
     * var10000 = z;
     * } else {
     * var21 = var6[f$mIc$sp$3_length];
     * f$mIc$sp$3_v = var21;
     */
    println("Res_4: " + list.fold(10)(_ + _))
    println("Res_4: " + arr.fold(10)(_ + _))
    val arr_temp = Array()
    println("Res_4: " + arr_temp.fold(10)(_ + _)) // you can see the result is 10

    // Demo_5
    println("Res_5: process")
    val num = arr.par.fold(0)((a,b) => {
      val name = Thread.currentThread().getName
      println(name,a,b)
      a+b
    })
    println("Res_5: " + num)

    // Demo_6
    println("Res_6: process")
    val num_2 = arr.par.foldLeft(0)((a,b) => {
      val name = Thread.currentThread().getName
      println(name,a,b)
      a+b
    })
    println("Res_6: " + num_2)
  }
}
