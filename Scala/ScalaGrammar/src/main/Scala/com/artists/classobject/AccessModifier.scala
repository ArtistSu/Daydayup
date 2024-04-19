package main.Scala.com.artists.classobject

import scala.beans.BeanProperty

/**
 * Access Modifier                     Highest Visible Range
 * public                              Visible to all
 * private                             Visible within this class and companion objects
 * private[Package Name]               This class and associated objects are visible in the ustc.marin package
 * private[Object Reference Name]      This object is visible
 * protected                           Subclasses are visible
 * protected[Package Name]             Visible in subclasses and ustc.marin packages
 * protected[Object Reference Name]    This object is visible
 */
class AccessModifier {
  var name = "Allen"
  private var age = 0

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, @BeanProperty age: Int) {
    this(name)
    this.age = age
  }
}

object AccessModifier {
  def main(args: Array[String]): Unit = {
    val obj_1 = new AccessModifier
    obj_1.name = "Allen_1"
    obj_1.age = 18
    println(s"Name: ${obj_1.name}, Age:${obj_1.age}")
  }
}

object TestAccessModifer {
  def main(args: Array[String]): Unit = {
    val obj_1 = new AccessModifier
    obj_1.name = "Allen_2"
    // obj_1.age = 10 -> You can only visit private attribute in companion object
    println(s"Name: ${obj_1.name}")
  }
}

private[classobject] class PrivateDemo {
  val name = "Allen_2"
  val age = 18
}

object TestPrivateDemo {
  def main(args: Array[String]): Unit = {
    val obj = new PrivateDemo
    println(s"Name:${obj.name} ,Age:${obj.age}")
  }
}

