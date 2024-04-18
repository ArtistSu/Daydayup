package com.artists.common

/**
 * Tip:
 * tuple does not support flatMap operation
 * The process of flatMap: map -> flatten
 */
object FlatMapTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4)
    val arr_1 = Array(arr,arr)

    // Demo_1
    var arr_res = arr_1.flatten.map(x => x*2)
    print("arr_res: ")
    arr_res.foreach(x => print(x + " "))
    println("")
    print("arr_res: ")
    arr_res = arr_1.flatMap(x => x)
    arr_res.foreach(x => print(x + " "))
    println("")

    /**
     * Exercise:
     * val arr = Array("Allen 100 30 70","Mic 50 80 90")
     *
     * Res:
     * Allen,100
     * Allen,30
     * Mic,50
     * Mic,80
     */
      // Method 1
    val arr_exc = Array("Allen 100 30 70","Mic 50 80 90")
    arr_exc.map(x => {
      val temp = x.split(" ")
      for(i <- temp.tail){
        println(temp(0) + " " + i)
      }
    })
    println("")

    // Method 2
    val arr_exc_res_2 = arr_exc.map(t => t.split(" ")).map(x =>x.tail.map(y => (x.head,y))).flatten
    arr_exc_res_2.foreach(x => println(x._1 + " " + x._2))
    println("")

    // Method 3
    val arr_exc_res_3 = arr_exc.map(t => t.split(" ")).flatMap(x => x.tail.map(y => (x.head,y)))
    arr_exc_res_3.foreach(x => println(x._1 + " " + x._2))
  }
}
