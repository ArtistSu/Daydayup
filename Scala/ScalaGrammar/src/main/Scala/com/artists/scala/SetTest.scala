package com.artists.scala

import scala.collection.immutable.HashSet

/**
 * Only distinct element can be put into the set
 * 1. Initialization
 * 2. Size
 * 3. Get value
 * 4. isEmpty
 * 5. Immutable hashset
 * 5.1 Size of immutable HashSet
 * 5.2 Generate a new set from original set
 * 6. Mutable set
 * 6.1 Add value
 * 6.2 Remove value
 * 6.3 IsEmpty
 */
object SetTest {
  def main(args: Array[String]): Unit = {
    // 1.Initialization
    val set = Set(1, 2, 3)
    val set_2 = Set(1, 1, 2, 3)

    // 2.Size
    println("size of set: " + set.size)
    println("size of set_2: " + set_2.size)

    // 3.Get value
    println("Get 1st element: " + set.head.toString)
    println("Get other elements except 1st element: " + set.tail.toString())

    // 4.isEmpty
    println("If set is empty?: " + set.isEmpty)

    // 5.Immutable HashSet
    import scala.collection.immutable.HashSet
    val set_immu = HashSet(1, 2, 3)

    // 5.1 Size of immutable HashSet
    println("Size of immutable hashset: " + set_immu.size)

    // 5.2 Generate a new set from original set
    println("Original immutable set: " + set_immu.toString())
    println("New set: " + (set_immu + 4).toString())
    println("Combine with another set: " + (set_immu ++ Set(5, 6)).toString())

    // 6.Mutable Set
    import scala.collection.mutable.HashSet
    /**
     * The following code will report an error, reason is there
     * are 2 hashset, one is for immutable, one is for mutable.
     * So reference to HashSet is ambiguous.So we need to provide
     * an alias.
     */
    //    val set_mu = new HashSet[Int]
    import scala.collection.mutable.{HashSet => HashSetMu}
    val set_mu = new HashSetMu[Int]

    // 6.1 Add value
    set_mu.add(1)
    print("After add set_mu is: ")
    set_mu.foreach((x: Int) => {print(x + " ")})
    println("")
    set_mu += 2
    print("After += set_mu is: ")
    set_mu.foreach((x: Int) => {print(x + " ")})
    println("")
    set_mu += (3,4)
    print("After += tuple set_mu is: ")
    set_mu.foreach((x: Int) => {print(x + " ")})
    println("")
    set_mu ++= Set(5,6)
    print("After ++= set set_mu is: ")
    set_mu.foreach((x: Int) => {print(x + " ")})
    println("")

    // 6.2 Remove value
    set_mu.remove(6)
    print("After remove set_mu is: ")
    set_mu.foreach((x: Int) => {print(x + " ")})
    println("")
    set_mu -= 5
    print("After -= set_mu is: ")
    set_mu.foreach((x: Int) => {print(x + " ")})
    println("")
    set_mu -= (3,4)
    print("After -= tuple set_mu is: ")
    set_mu.foreach((x: Int) => {print(x + " ")})
    println("")
    set_mu --= Set(1,2)
    print("After --= set set_mu is: ")
    set_mu.foreach((x: Int) => {print(x + " ")})
    println("")

    // 6.3 IsEmpty
    println("set_mu is empty? " + set_mu.isEmpty)
  }
}
