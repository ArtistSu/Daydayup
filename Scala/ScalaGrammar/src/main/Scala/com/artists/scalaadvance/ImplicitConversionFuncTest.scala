package main.Scala.com.artists.scalaadvance

/**
 * 1. Implicit conversion functions refer to functions declared with
 * the implicit keyword and taking a single parameter. Such functions
 * are automatically applied.
 * 2. Execution order (base on the following code convert Int to String)
 *  2.1 When executing, check whether the Int type has a length member,
 *  and if so, call it directly.
 *  2.2 If not, but does the current environment have an implicit
 *  function that can convert Int to a type with the length member?
 *  If so, call it.
 *  2.3 Throw an exception
 * 3. In shell we can use :implicit -v to check how many implicit
 * conversion function by default.

 */
class ImplicitConversionFuncTest {
}

object MyImplicitIntFunc{
  implicit def int2StringFunc = (x:Int) => x.toString
}
object ImplicitConversionFuncTestObj{
  def main(args: Array[String]): Unit = {
    val int_val = 12345
    // The following code will report an error, cause by length is
    // not a member of Int.
//    println(int_val.length)

    // Base on the above error, we can import implicit conversion func
    import MyImplicitIntFunc.int2StringFunc

    // Or you can directly write in the class, but better don't to use this way
//    implicit def int2StringFunc = (x:Int) => x.toString
    println(int_val.length)
  }
}
