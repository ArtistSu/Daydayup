package com.artists.scala

/**
 * Tuple in scala will simple encapsulate various of different object.
 * Scala provide Tuple[N], the range of N is 1-22, Tuple[N] will be
 * used to create a tuple with N elements.
 * 1. Initialization
 * 2. Get value -> index from 1, but the index of array is from 0
 * 3. Methods
 */
object TupleTest {
  def main(args: Array[String]): Unit = {
    // 1.Initialization
    val tuple3:Tuple3[Int,String,Int] = new Tuple3[Int,String,Int](1,"ArtistS",20)
    val tuple2:Tuple2[Int,String] = new Tuple2[Int,String](1,"ArtistS")
    val tuple = ("ArtistS",10)
    val tuple_special = (1,("ArtistS",20),"google")

    // 2.Get value
    println("Get the first value: " + tuple_special._1)
    println("Get the first value of the second element: " + tuple_special._2._1)

    // 3.Methods
    println("swap: " + tuple.swap.toString())

  }
}
