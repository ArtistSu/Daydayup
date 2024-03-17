package com.artists.scala

/**
 * Use List, Array ... to set value to various of variable in one
 * go.
 */
object CollectiveSetValueTest {
  def main(args: Array[String]): Unit = {
    // 1.Array
    val Array(a,b,c) = Array(1,2,3)
    println(s"a: ${a}")
    println(s"b: ${b}")
    println(s"c: ${c}")

    val Array(d,e,f) = Array(1,2,"a")
    println(s"d: ${d}")
    println(s"e: ${e}")
    println(s"f: ${f}")

    // 2.List
    val List(g,h,i) = List(1,2,3)
    println(s"g: ${g}")
    println(s"h: ${h}")
    println(s"i: ${i}")

    val list,List(j,k,l) = List(1,2,3)
    println(s"list: ${list}")

    // 3.Tuple
    val (m,n,o) = (1,2,"a")
    println(s"m: ${m}")
    println(s"n: ${n}")
    println(s"o: ${o}")

    /**
     * 4. Set can use this way to set value to multiple variable
     * cause object Set is not a case class, nor does it have an
     * unapply/unapplySeq member
     */
  }
}
