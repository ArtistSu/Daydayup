package com.artists.common

import java.io.File
import scala.collection.parallel.CollectionConverters.ImmutableSeqIsParallelizable
import scala.io.Source

object Wordcount {
  def main(args: Array[String]): Unit = {

    // Demo_1
    println("Demo_1")
    val list = List("hello tom hello jack", "hello tom hello world world world")
    list.flatMap(t => t.split(" ")).groupBy(t => t).mapValues(t => t.size).foreach(println)
    println("")

    // Demo_2
    println("Demo_2")
    val it = Source.fromFile("src/main/resources/word.txt").getLines()
    val data_1 = it.flatMap(t => t.split(" "))
    val data_2 = data_1.map(t => (t,1)).toList
    val map = data_2.groupBy(t => t._1)
    map.mapValues(t=>t.size).foreach(println)
    println("")

    // Demo_3
    println("Demo_3")
    val it_2 = Source.fromFile("src/main/resources/word.txt").getLines()
    val data_3 = it_2.flatMap(t => t.split(" "))
    val data_4 = data_3.map(t => (t,1)).toList
    val map_2 = data_4.groupBy(t => t._1)
    import scala.collection.parallel.CollectionConverters._
    map_2.mapValues(t => t.par.aggregate(0)((a,b)=>a+b._2, (a,b)=>a+b)).foreach(println)
    println("")
  }
}
