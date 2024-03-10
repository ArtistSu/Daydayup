package com.artists.scala

object YieldTest {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // How to get the result after calculation
    // Method 1
    val new_arr = for (i: Int <- arr) i * 2

    /**
     * The following code will report error.Because
     * there is no return value for for loop by default
     */
//    for (i: Int <- new_arr) {
//      println(i * 2, " ")
//    }

    /**
     * We need to use yield to save the result
     * Yield will put iteratively generated values into a list,
     * you can also think yield will create a list
     * automatically. If you don't use yield the return value
     * of the above code will be Unit.
     */
    val new_arr_bingo= for (i:Int <- arr) yield {
      if(i % 2 == 0){
        println("Yield - even ",i)
        i
      }else{
        println("Yield - odd ", i)
        i * 2
      }
    }

    // Validate
    for(i:Int <- new_arr_bingo) println(i)
  }

}
