package com.artists.scala

/**
 * 1. Definition: val [var_name]= ([var1]:[var1_type],[var2]:[var2_type]) => {function body}
 * 2. Anonymous function
 * 3. Conversion between method & function
 *    we can use method + space + _ to convert method to function
 *    e.g. calculate(1,2,sub _) -> here sub _ is a function
 *    but scala will help you to convert it -> implicit conversion
 *    e.g. calculate(1,2,sub)
 * 4. You can also see this way to define a function
 * e.g.
 * val [function name]: [(variable_1 type, variable_2 type, ...] => [return variable type] = [(variable_1 name, variable_2 name)] => {[function body]}
 * val func:(Int,Int) => Int = (x,y) => {x+y}
 */
object FunctionTest {
  def main(args: Array[String]): Unit = {

    val add = (x: Int, y: Int) => {
      x + y
    }
    println("Add function result is " + calculate(1, 2, add))

    // You can use getFunc() to get a function, and then you can
    // call this function as well
    println("getFunc result is " + getFunc()(1, 2))

    // You can also define a complicated method and function here
    println("getFunc_2 result is " + getFunc2(1, 2)(2))

    // Anonymous Function
    println("Anonymous function result is " + calculate(1, 2, (x: Int, y: Int) => x + y))

    // Convert method to function
    println("Convert method to function: " + calculate(2,1,sub))
    println("Convert method to function: " + calculate(2,1,sub _))
  }

  def sub(x: Int, y: Int): Int = {
    x - y
  }

  /**
   * @param x -> parameter 13
   * @param y -> parameter 2
   * @param f -> specific function
   * @return use function f to handle x and y
   */
  def calculate(x: Int, y: Int, f: (Int, Int) => Int) = f(x, y)

  /**
   * You can use the function as a return value of a method
   */
  def getFunc() = {
    val func = (x: Int, y: Int) => {
      x + y
    }
    func
  }

  def getFunc2(a: Int, b: Int) = {
    val func = (x: Int) => {
      a * x + b
    }
    func
  }
}
