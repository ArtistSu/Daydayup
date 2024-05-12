package main.Scala.com.artists.scalaadvance

/**
 * 1. If the function is passed all expected arguments, then it is
 * fully applied. If only a few arguments are passed and not all
 * arguments are passed, a partially applied function will be returned.
 * In this way, some parameters can be easily bound, and the remaining
 * parameters can be filled in later;
 * 2. Partial parameters are to fix some parameters and pass in some
 * parameters.
 */
class PartialParameterFuncTest {
  // This is a normal function
  def multi(a: Int, b: Int) = a * b

  /**
   * Partial parameters are to fix some parameters and pass in some
   * parameters.
   * 10 -> fixed parameter
   * _:Int -> Make parameter placeholders for passing in parameters,
   */
  val func_1 = multi(10, _: Int)

  // We can also use this way to input a parameter
  val func_2 = (b: Int) => multi(10, b)

  // We can also define the initical value for the parameter
  def mult_2(a: Int, b: Int = 2) = {
    a * b
  }
}

object PartialParameterFuncTestObj {
  def main(args: Array[String]): Unit = {
    // func_1(2) == multi(10,2)
    println((new PartialParameterFuncTest).func_1(2))
    println((new PartialParameterFuncTest).func_2(2))
    println((new PartialParameterFuncTest).mult_2(10))
  }
}
