package main.Scala.com.artists.classobject

/**
 * 1. Abstract class in Scala is similar to abstract class in
 * Java, but there are no abstract properties in Java, Scala can
 * set abstract properties.
 * 2. When a child class extends a parent class, the child class
 * must implements all abstract properties and methods in the
 * parent class.
 * 3. Child class override abstract members can without keyword
 * override.
 * 4. Child class override non-abstract members must add keyword
 * override.
 * 5. You can use super.[methodName] to call the method in the
 * parent class.
 * 6. If there is a constructor in a parent class, the child class
 * must call the primary constructor or auxiliary constructor in
 * the parent class.
 * 7. Auxiliary constructors can not call constructors in a parent
 * class.
 * 8.Child class can use
 *  extend Fruit(color:String) -> to call primary constructor of
 *  parent class
 *  extend Fruit("blue","2.9") -> to call auxiliary constructor of
 *  parent class
 */

abstract class Fruit(val color:String){
  var price:Double = _
  def this(color:String,price:Double) = {
    this(color)
    this.price = price
  }

  // Define common properties
  val name:String = "Fruit"
  // Define abstract properties
  val brand:String
  // Define common method
  def description = {
    println("This is a common method in abstract class")
  }
  // Define abstract method
  def action():Unit
}

// If the parent class has constructors, the child class must call
// the primary or auxiliary constructor in parent class. Here I call
// auxiliary constructor.
class Apple(color:String, category:String) extends Fruit("red",1.0) {
  // Child class override abstract members can without keyword
  // override
  val brand:String = "Lady Apple"
  def action(): Unit = {
    println("Override abstract method in the parent class can without keyword override")
  }

  // Child class override non-abstract members must add keyword
  // override
  override val name:String = "Fruit - Apple"

  override def description(): Unit = {
    super.description
    println(s"color:${color}," +
      s"brand:${brand}," +
      s"name:${name}," +
      s"category:${category}," +
      s"price:${price}")
    action()
  }
}


object AbstractClassTest{
  def main(args: Array[String]): Unit = {
    val apple = new Apple("blue","sweet apple")
    apple.description()
  }
}
