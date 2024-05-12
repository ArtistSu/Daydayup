package main.Scala.com.artists.scalaadvance

/**
 * 1. [B<:A] -> UpperBound
 *  A is the parent class of B. B must be A or child class of A
 * 2. [B>:A] -> LowerBound
 *  B is the parent class of A. A must be B or child class of B
 * 3. [-A] -> contrarian
 *  C[-T]: If A is a child class of B, C[B] is a child class
 *  of C[A]. This usually use for parameter type.
 * 4. [+B] -> covariance
 *  C[+T]: If A is a child class of B, C[A] is a child class
 *  of C[B]. This usually use for return type.
 * 5. C[T]: No matter what relationship between A and B, C[A]
 *  and C[B] have no affiliation。
 */

// Define an abstract class with generic
abstract class GenericDemo[T](val t:T){
  def printInfo():Unit
}

// Child class extends parent class, reify generics into Int
class GenericIntDemo[Int](t:Int) extends GenericDemo[Int](t:Int) {
  override def printInfo(): Unit = {
    println(s"GenericIntDemo(${t})")
  }
}

// Child class extends parent class, reify generics into String
class GenericStringDemo[Int](t:Int) extends GenericDemo[Int](t:Int) {
  override def printInfo(): Unit = {
    println(s"GenericStringDemo(${t})")
  }
}

// Define classes with multiple generics
class GenericMulDemo[A,B,C](val a:A, val b:B, val c:C){
  override def toString: String = s"${a}, ${b}, ${c}"
}

object SexEnumObj extends Enumeration{
  type SexEnum = Value
  val boy = Value("Boy")
  val girl = Value("Girl")
}

object GenericDemo{
  def main(args: Array[String]): Unit = {
    val demo = new GenericIntDemo[Int](10)
    demo.printInfo()
    val demo_2 = new GenericIntDemo[String]("Allen")
    demo_2.printInfo()
    val demo_3 = new GenericMulDemo[String, Int, String]("Allen", 20, "boy")
    println(demo_3)
    val demo_4 = new GenericMulDemo[String, Int, String]("Allen",20, SexEnumObj.boy.toString)
    println(demo_4)
  }
}

/**
 * contrarian
 * If A is a child class of B, C[B] is a child class of C[A]
 * A -> Bird
 * B -> SubBird
 */
class Animal {}
class Bird extends Animal {}
class SubBird extends Bird {}
class Consumer[-T] (t:T){}
class Consumer_2[+T] (t:T){}
class ConstrarianTest extends App{
  val c:Consumer[Bird] = new Consumer[Bird](new Bird)
  val c_2:Consumer[SubBird] = c
}

/**
 * covariance
 * If A is a child class of B, C[A] is a child class of C[B]
 * A -> Bird
 * B -> Animal
 */
class ConvarianceTest extends App{
  val c:Consumer_2[Bird] = new Consumer_2[Bird](new Bird)
  val c_2:Consumer_2[Animal] = c
}




