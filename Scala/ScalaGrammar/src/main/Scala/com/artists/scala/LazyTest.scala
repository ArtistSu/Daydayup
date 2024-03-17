package com.artists.scala

/**
 * This variable will only be instantiated when a lazy variable
 * is called, similar to the lazy mode of singleton mode in Java;
 * Example 1: The variable will init no matter you use or not
 * Example 2: The variable will use when the variable use
 */
object LazyTest {
  def init():Unit = {
    println("[Init Stage]")
  }

  def main(args: Array[String]): Unit = {
    println("=== Demo 1 without lazy ===")
    val lazy_var = init()
    println("init after")
    println(lazy_var)
    println(lazy_var)

    println("=== Demo 1 without lazy ===")
    lazy val lazy_var_1 = init()
    println("init after")
    println(lazy_var_1)
    println(lazy_var_1)


  }
}
