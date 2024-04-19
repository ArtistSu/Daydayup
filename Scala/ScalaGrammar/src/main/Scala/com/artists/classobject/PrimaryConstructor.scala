package main.Scala.com.artists.classobject

/**
 * 1. Primary constructor
 * 1.1 When you define a class, you define a constructor.It is
 * the content inside ()
 * 1.2 Parameters in the main constructor can have default
 * values; When a parameter has a default value and the
 * parameter comes at the end, there is no need to assign a
 * value to the parameter when creating the object.
 * 1.3 Parameters in the primary constructor can be modified with
 * val or var, or without var or val.
 * - var: Parameters modified by var can be accessed and modified
 * in other classes.
 * - val: Parameters modified by var can be accessed but can not
 * be modified in other classes.
 * - without var and val: Parameters modified without var and val
 * can not be accessed or modified in other classes.
 */
class PrimaryConstructor(var name:String, val age:Int=10, addr:String = "Sichuan") {

}
object PrimaryConstructorObj{
  def main(args: Array[String]): Unit = {
    val pc = new PrimaryConstructor("Allen",10)
    println(s"Name: ${pc.name}, Age: ${pc.age}")
    pc.name = "Lar"
    println(s"Name: ${pc.name}, Age: ${pc.age}")
  }
}



