package com.artists.common

/**
 * 1. Aggregate -> Already deprecated after 2.13.0, use foldLeft
 * instead.
 * aggregate([initial value])([seqop function],[combop function])
 */
object AggregateTest {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)

    /**
     * If the collection is not parallel collection, combop function
     * will not execute.
     */
    // Demo_1
    val sum:Int = list.aggregate(0)((a:Int, b:Int) => {
      println(s"step1:a=${a}, b=${b}")
      a+b
    },
      (a:Int, b:Int) => {
        println(s"step2:a=${a}, b=${b}")
        a+b
      }
    )
    println("Demo_1: " + sum)

    /**
     * If the collection is parallel collection, combop function
     * will execute.
     */
    // Demo_2
    import scala.collection.parallel.CollectionConverters._
    val sum2:Int = list.par.aggregate(0)((a:Int, b:Int) => {
      println(s"step1:a=${a}, b=${b}")
      a+b
    },
      (a:Int, b:Int) => {
        println(s"step2:a=${a}, b=${b}")
        a+b
      }
    )
    println("Demo_2: " + sum2)

    // Demo_3
    val arr =List(List(1,2,3),List(3,4,5),List(2),List(0))
    val sum3 = arr.aggregate(0)(_+_.reduce(_+_),_+_)
    println("Demo_3: " + sum3)
  }
}
