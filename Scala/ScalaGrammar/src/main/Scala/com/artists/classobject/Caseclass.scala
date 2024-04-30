package main.Scala.com.artists.classobject

/**
 * Case Class
 * 1. Add keyword case before class, this class called case class, it implements Serializable interface by default.
 * 2. Scala will create an companion object automatically for Case Class, and generate apply() and unapply() for
 * companion object.
 * 3.
 *
 */
case class People(name:String, age:Int)

object testPeople {
  def main(args: Array[String]): Unit = {
    // No need to use new to create an object, and also you don't need to create apply()
    val people = People("Allen",18)
    println(people.name + "," + people.age)

    // You also don't need to create unapply()
    people match {
      case People(x,y) => println(x + "," + y)
    }
  }
}
