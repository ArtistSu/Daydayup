package main.Scala.com.artists.scalaadvance

/**
 * 1. Higher-order function must satisfy aat least one of the
 * following condition:
 *  - Accept one or more functions as input
 *  - Output a function
 */
class AdvanceFunctionTest {

  // output int
  def add(a:Int, b:Int) = {
    a+b
  }

  // output function int => int
  /**
   * def add_3(a:Int,b:Int) = {
   *  val tempFunc_res = (c:Int) => {
   *    a + b + c
   *  }
   *    tempFunc_res
   * }
   */
  def add_2(a:Int,b:Int) = (c:Int) => {
    a + b + c
  }

  // input a function -> return a function
  val func_1:(Int,Int) => Int = (a,b) => {a * b}
  def add_3(func:(Int,Int) => Int) = func_1

  def calculate(x:Int, y:Int, func:(Int,Int)=>Int) = func(x,y)
  def sub_1(x:Int, y:Int) = {x - y}
}

object AdvanceFunctionTestObj{
  def main(args: Array[String]): Unit = {
    val obj = new AdvanceFunctionTest
    // add_2(1,2) will return a function, c is the parameter of
    // this function
    println(obj.add_2(1,2)(3))

    /**
     * Here you give a func_2 as a parameter, no matter which
     * function you provide it will return func_1, so the code
     * will looks like func_1(2,3)
     */
    val func_2 = (a:Int,b:Int) => a + b
    println(obj.add_3(func_2)(2,3))

    /**
     * Here is a case for the above knowledge
     */
    println(obj.calculate(20,10,obj.sub_1))
    val arr = Array(1,2,3)
    val spec_func = (x:Int, y:Int) => {x*2 + y*2}
    // (1*2 + 2*2)*2 + 3*2 = 18
    println(arr.reduce((a,b) => obj.calculate(a,b,spec_func)))

  }
}
