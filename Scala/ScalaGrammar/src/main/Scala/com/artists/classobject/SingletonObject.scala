package main.Scala.com.artists.classobject

/**
 * 1. There is no static keyword in scala like java
 * 2. In scala, what is modified with object is a singleton object.
 * The singleton object mainly stores constants and tool methods.
 */
class SingletonObject {
  val name = "Allen"
  def sayHello(name:String) = println(s"hellp ${name}")
}

object SingletonObjectObj{
  println("init")
}

object Test{
  def main(args: Array[String]): Unit = {
    // You will find the following address is same
    val t1 = SingletonObjectObj
    val t2 = SingletonObjectObj
    val t3 = SingletonObjectObj
    println(t1)
    println(t2)
    println(t3)
  }
}
