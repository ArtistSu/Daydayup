package com.artists.scala

import scala.::

/**
 * 1. Immutable List -> Elements and length can not be changed
 * 1.1 Initialization
 * 1.2 Get value
 * 1.3 Methods
 * 1.4 Nil -> Empty list
 * 2. Mutable List
 * 2.1 Mutable list initialization
 * 2.2 Set value
 * 2.3 Remove value
 * 2.4 Size
 * 2.5 [:: | +: | :+ | ++ | :::]
 */
object ListTest {
  def main(args: Array[String]): Unit = {
    // 1.1 Immutable List initialization
    val list = List[Int](1,2,3)
    val list_2 = List[Int](4,5,6)

    // 1.2 Get value
    println("1st element in list is " + list(0))

    // 1.3 Methods
    println("size: " + list.size)
    println("Add 0 before list: " + list.::(0).toString())
    println("Add 0 before list: " + list.+:(0).toString())
    println("Add 0 before list: " + (0 :: list).toString())
    println("Add 0 before list: " + (0 +: list).toString())
    println("Add 0 after list: " + (list:+0).toString())
    println("Add 0 after list: " + (list.:+(0)).toString())

    println("Combine 2 list: " + (list ++ list_2).toString())
    println("Combine 2 list: " + (list ::: list_2).toString())

    // scala.collection.immutable.Nil.type = List()
    println("Nil: " + Nil.toString())
    println("Add 0  1 before Nil: " + (0 :: 1 :: Nil).toString())

    // 2.1 Mutable list initialization
    import scala.collection.mutable.ListBuffer
    val list_mu = new ListBuffer[Int]

    // 2.2 Set value
    println("Add element in to list: " + list_mu.append(1).toString)
    println("Add element in to list: " + (list_mu+=2).toString())
    println("Add tuple in to list: " + (list_mu+=(3,4)).toString())
    println("Add array in to list: " + (list_mu++=Array(5,6)).toString())
    println("Add list in to list: " + (list_mu++=List(7,8)).toString())
    list_mu.insert(0,-1)
    println("Add -1 at index 0 of list: " + list_mu.toString)

    // 2.3 Remove value
    list_mu.remove(0)
    println("Remove the 1st element of list: " + list_mu.toString)
    println("Remove the list from list: " + (list_mu --= List(7,8)).toString())
    println("Remove the array from list: " + (list_mu --= Array(5,6)).toString())
    println("Remove the tuple from list: " + (list_mu -= (3,4)).toString())
    println("Remove the tuple from list: " + (list_mu -= 2).toString())

    // 2.4 Size
    println("List size: " + list_mu.size)

    // 2.5 [:: | +: | :+ | ++ | :::]
    // :: -> ListBuffer can't use
    println("+= :" + (list_mu+=1).toString())
    println(":+ :" + (list_mu:+2).toString())
    println("++ :" + (list_mu++Array(3,4)).toString())
    // ::: -> ListBuffer can't use
  }

}
