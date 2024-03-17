package com.artists.scala

/**
 * 1. Immutable map
 * 1.1 Size
 * 1.2 Get value
 * 1.3 Cast Any -> Int
 * 1.4 Get value of exist or not exist key
 * 1.5 Can't change the original elements in the map, but it
 * can generate a new map.
 *
 * 2. Mutable map
 * 2.1 Add value
 * 2.2 Remove value
 * 2.3 Iterate
 */
object MapTest {
  def main(args: Array[String]): Unit = {
    // 1.Immutable map -> k,v can use k-> v also you can use (k,v)
    val map_immu = Map("Allen" -> 1, "Gar" -> (2, 3), ("Mic", 3))

    // 1.1 Size
    println("map_immu size: " + map_immu.size)

    // 1.2 Get values
    println("Value of Allen(Any): " + map_immu("Allen"))

    // 1.3 Cast Any to Int
    map_immu("Allen").asInstanceOf[Int]
    println("Value of Allen(Int): " + (map_immu("Allen").getClass.getSimpleName) + " " + map_immu("Allen"))

    /**
     * If k not exist and you use map("[key]") this way to get value,
     * it will throw an exception, key not found. You can use
     * map.get("[key]") to get an Option object.
     * Option object has 2 sub-class:
     * None -> no data
     * Some -> Has data, you can use get() to get the value in the
     * Some object.
     *
     * You can also you getOrElse to set a default value if the key
     * doesn't exist.
     */
    // 1.4 Get value of exist or not exist key
    println("Value of not exist key Lar: " + map_immu.get("Lar") + " " + map_immu.get("Lar").getClass.getSimpleName)
    println("Value of not exist key Allen: " + map_immu.get("Allen").get + " " + map_immu.get("Allen").get.getClass.getSimpleName)

    println("Value of not exist key Ste: " + map_immu.getOrElse("Ste", 4))

    // 1.5 Can't change the original elements in the map, but it
    //     can generate a new map.
    val map_immu_2 = (map_immu + ("Ste" -> 4))
    println("Add 1 element: " + map_immu_2.toString())
    val map_immu_3 = (map_immu_2 + (("Raj", 5)))
    println("Add 1 element: " + map_immu_3.toString())
    val map_immu_4 = (map_immu_3 ++ Map("Kas" -> 6))
    println("Add 1 element: " + map_immu_4.toString())
    val map_immu_5 = (map_immu_4 - "Kas")
    println("Remove 1 element: " + map_immu_5.toString())
    val map_immu_6 = (map_immu_5 - ("Raj"))
    println("Remove 1 element: " + map_immu_6.toString())

    // 2.Mutable map
    import scala.collection.mutable.HashMap
    val map_mu = new HashMap[String,Int]

    // 2.1 Add value
    map_mu.put("Allen",1)
    println("Add 1 value into mutable map: " + map_mu.toString())
    map_mu += ("Raj" -> 2)
    println("Add 1 value into mutable map: " + map_mu.toString())
    map_mu += (("Mic",3))
    println("Add 1 value into mutable map: " + map_mu.toString())
    map_mu ++= Map("Lar" -> 4)
    println("Add 1 value into mutable map: " + map_mu.toString())

    // 2.2 Remove value
    map_mu.remove("Lar")
    println("Remove 1 value of mutable map: " + map_mu.toString())
    map_mu -= "Lar"
    println("Remove 1 value of mutable map: " + map_mu.toString())
    map_mu -= ("Lar","Mic")
    println("Remove 1 tuple of mutable map: " + map_mu.toString())

    // 2.3 Iterate
    println("Iterate map method 1: ")
    for( k <- map_mu.keySet){
      println(s"Key:${k}, Value:${map_mu(k)}")
    }

    println("Iterate map method 2: ")
    for((k,v) <- map_mu){
      println(s"Key:${k}, Value:${v}")
    }

    println("Iterate value: ")
    for(v <- map_mu.values){
      println(s"Values:${v}")
    }



  }
}
