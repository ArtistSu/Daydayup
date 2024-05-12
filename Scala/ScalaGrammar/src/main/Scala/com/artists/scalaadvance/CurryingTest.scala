package main.Scala.com.artists.scalaadvance

/**
 * 1. Currying is a technique that transforms a function that accepts
 * multiple parameters into a function that accepts a single parameter
 * (the first parameter of the original function), and returns a new
 * function that accepts the remaining parameters and returns a result.
 * 2. Keep in mind, please don't use currying adn implicit in a same
 * class.
 *  Execution order:
 *  2.1 check whether the current environment has an implicit value
 *  with the same type as the implicit parameter. If found, use the
 *  implicit value as the implicit parameter.
 *  2.2 If not found, check if the implicit parameter has a default
 *  value. If so, use the default value.
 *  2.3 If it is not found yet, throw an exception
 * 3. You can use implicitly[Int] to extract the implicit value
 * of the current environment and assign it to the variable.
 * 4. You can define multiple implicit variables in a same class. but
 * you can't define 2 same type implicit variables. e.g.
 * implicit val im_int_1 = 1
 * implicit val im_int_2 = 2
 * it will report an error
 * 5. The correct to use implicit variables is to declare them in a
 * separate object e.g.
 * object MyImVal{
 *  implicit val b1:Int = 1
 *  implicit val b2:Int = 2
 * }
 * when you want to use it, you can import one of them
 * object Test{
 *  def main(args: Array[String]): Unit = {
 *    import util.MyImVal.b1
 *    (new CurryingTest).add_curry_4(8) ->result is 8 + 1 = 9
 *  }
 * }
 */
class CurryingTest {
  /**
   * normal add():
   * def add(x:Int,y:Int) = {x+y}
   * currying add()
   * def add_curry_1(x:Int)(y:Int) = {x+y}
   * def add_curry_2(x:Int) = (y:Int) => {x+y}
   */
  def add_curry_1(x: Int)(y: Int) = {
    x + y
  }

  def add_curry_2(x: Int) = (y: Int) => {
    x + y
  }

  def add_curry_3(a: Int)(b: Int)(c: Int)(d: Int)(e: Int)(f: Int)(g: Int) = {
    a + b + c + d + e + f + g
  }

  def add_curry_4(x: Int)(implicit y: Int = 5) = {
    x + y
  }
}

object CurryingTestObj {
  def main(args: Array[String]): Unit = {
    // How to use curring? Here is an underline for parameter placeholder
    val func_1 = (new CurryingTest).add_curry_1(4) _
    println("func_1 res: " + func_1(5))
    val func_2 = (new CurryingTest).add_curry_2(4)
    println("func_2 res: " + func_2(5))
    println("func_3 res: " + (new CurryingTest).add_curry_2(4)(5))

    // A complicated case
    val arr = Array(1, 2, 3, 4, 5, 6, 7)
    val fold_res = arr.fold(0)(_ + _)
    println("fold_res: " + fold_res)
    // If you want to use currying to implement this
    println("add_curry_3 res: " + (new CurryingTest).add_curry_3(1)(2)(3)(4)(5)(6)(7))


    /**
     * Keep in mind, please don't use currying adn implicit in a same
     * class.
     * implicit modified parameter, indicating that the parameter is
     * an implicit parameter
     * e.g. (implicit b:Int = 5)
     * Execution order:
     * 1. check whether the current environment has an implicit value
     * with the same type as the implicit parameter. If found, use the
     * implicit value as the implicit parameter.
     * 2. If not found, check if the implicit parameter has a default
     * value. If so, use the default value.
     * 3. If it is not found yet, throw an exception
     */
    // We pass parameters directly
    println("pass parameters directly res: " +
      (new CurryingTest).add_curry_4(8)(5))

    //    //  We don't pass the implicit parameter
    //    // Please comment out the related code about
    //    // "We define an implicit value" and open this
    //    println("We don't pass the implicit parameter res: " +
    //      (new CurryingTest).add_curry_4(8))

    // We define an implicit value
    implicit val im_val_int: Int = 8
    println("We define an implicit parameter res: " +
      (new CurryingTest).add_curry_4(8))

    // We can also use implicitly[Int] to Extract the implicit value
    // of the current environment and assign it to the variable. Here
    // we define 2 implicit value, but one is Int, one is String. So
    // the code can run normally. But if we define 2 implicit int,
    // it will report an error
    implicit val im_val_string:String = "aa"
    val extract_im_val = implicitly[Int]
    println("extract_implic_val: " + extract_im_val)

  }
}