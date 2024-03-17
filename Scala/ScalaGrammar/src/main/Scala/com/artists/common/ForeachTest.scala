package com.artists.common

/**
 *
 */
object ForeachTest {
  def main(args: Array[String]): Unit = {
    // Demo 1
    val arr:Array[Int] = Array[Int](1,2,3,4,5,6,7,8)
    arr.foreach(t => {
      if(t % 2 == 0){
        print(s"${t} ")
      }else{
        print(t*2 + " ")
      }
    })
    println("")

    // Demo 2
    val arr_2 = Array(Array(11,22,33,44), Array(1,2,3,4))
    arr_2.foreach(arr => arr.foreach(x => {
      if(x % 2 ==0 ){
        print(s"${x}")
      }else{
        print(x*2)
      }
      print(" ")
    }))
  }
}
