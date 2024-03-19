package com.artists.common
import scala.collection.parallel.CollectionConverters._

/**
 * 1.reduce : reduce is from left -> right
 * 2.reduceLeft: reduceLeft is from left -> right
 * 3.reduceRight: reduceRight is from right to left
 *
 * Single thread: reduce is same as reduceLeft
 * Multi-thread: reduce will use CPU to do reduce, the result
 * may not correct, reduceLeft / reduceRight has direction and
 * can only run in a single thread.
 */
object ReduceTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5,6,7,8,9)
    val arr_2 = Array(("Allen",1),("Mic",2))

    // Demo_1 -> (((1+2)+3)+....)
    println("Res: " + arr.reduce((a,b)=>a-b))

    // Demo_2
    println("Res_2: " + arr.reduce((a,b)=> a*(a-b)))

    // Demo_3
    println("Res_3: " + arr_2.reduce((a,b)=> (a._1+"-"+b._1,a._2 + b._2)))

    // Demo_4
    println("Res_4: ")
    val res_4 = arr.par.reduce((a,b) => {
      val name = Thread.currentThread().getName
      println(name,a,b)
      a - b
    })
    println(res_4)

    // Demo_5
    println("Res_5: ")
    val res_5 = arr.par.reduceLeft((a,b) => {
      val name = Thread.currentThread().getName
      println(name,a,b)
      a - b
    })
    println(res_5)

    // Demo_6
    println("Res_6: ")
    val res_6 = arr.par.reduceRight((a,b) => {
      val name = Thread.currentThread().getName
      println(name,a,b)
      a - b
    })
    println(res_6)

    // Demo_6
    /**
     * Please pay attention
     * scala> arr.reduceLeft((a:AnyVal,b:Int) => (a.asInstanceOf[Int]+b).asInstanceOf[AnyVal])
     *
     * arr.reduce((a:AnyVal,b:Int) => (a.asInstanceOf[Int]+b).asInstanceOf[AnyVal])
     * <console>:13: error: type mismatch;
     * found   : (AnyVal, Int) => AnyVal
     * required: (AnyVal, AnyVal) => AnyVal
     *
     * Caused by reduce(op: (U,U) => U):U
     *           reduceLeft(op: (U,T) => U):U
     */

    // Demo_7
    /**
     * If parameter only exist once after =>
     * You can omit parameters until =>, and replace the parameter
     * with _
     */

    println("Res_7: " + arr.reduce(_ + _*2))


  }
}
