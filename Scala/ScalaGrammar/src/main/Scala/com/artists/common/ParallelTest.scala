package com.artists.common

/**
 * Use [xxx].par to change collection to parallel collection,
 * then you can use multiple thread to do operation.
 *
 * Scala 2.12 should import import scala.collection.parallel.immutable.ParVector
 * Scala 2.13 Parallel collections have been moved in Scala 2.13 to separate module scala/scala-parallel-collection
 *
 * <dependency>
 * <groupId>org.scala-lang.modules</groupId>
 * <artifactId>scala-parallel-collections_2.13</artifactId>
 * <version>0.2.0</version>
 * </dependency>
 *
 * And
 *
 * import scala.collection.parallel.CollectionConverters._
 */
object ParallelTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5,6,7,8,9)

    import scala.collection.parallel.CollectionConverters._

    arr.par.map(x => {
      val name = Thread.currentThread().getName
      (name,x)
    }).foreach(println)
  }
}
