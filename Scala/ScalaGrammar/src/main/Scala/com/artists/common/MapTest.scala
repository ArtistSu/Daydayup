package com.artists.common

object MapTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,5)
    val arr_ex = Array(("Allen",Array(10,20,30,50,35)),("Lar",Array(20,100,20,80)))

    // Demo_1
    val arr_res = arr.map(x => x*2)
    print("Demo1: ")
    arr_res.foreach(x => {print(x + " ")})
    println("")

    // Demo_2
    val arr_2_res = arr.map(x => if(x < 5) x+1 else x ).map(x => if(x%2 == 0) x else x*2)
    print("Demo2: ")
    arr_2_res.foreach(x => {print(x + " ")})
    println("")

    // Demo_3
    val arr_3_res = arr.map(x => if(x%2 == 0) (x,"even") else  (x,"odd"))
    print("Demo3: ")
    arr_3_res.foreach(x => {print(x + " ")})
    println("")

    // Demo_4
    val arr_4_res = arr_ex.map(tp => (tp._1,tp._2.max))
    print("Demo4: ")
    arr_4_res.foreach(x => {print(x + " ")})
    println("")

    // Demo_5
    val arr_5_res = arr_ex.map(tp => (tp._1,tp._2.map(x => if(x>30) "Pass" else "Failed")))
    print("Demo5: ")
    arr_5_res.foreach(x => {
      print(x._1+":")
      x._2.foreach(x => print(x+","))})
    println("")

    // Demo_6
    val arr_6_res = arr_ex.map(tp => (tp._1,tp._2.sum *1.0 / tp._2.length))
    print("Demo6: ")
    arr_6_res.foreach(x => {print(x + " ")})
    println("")
  }
}
