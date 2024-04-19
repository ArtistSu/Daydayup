package main.Scala.com.artists.classobject

import scala.beans.BeanProperty

/**
 * 1. Auxiliary Constructor
 * 1.1 Auxiliary constructors can be understood as constructor
 * overloading in Java.
 * 1.2 The 1st line of auxiliary constructor must call primary
 * constructor.
 * 1.3 Auxiliary constructor is not necessary. If it is defined in
 * the class, the auxiliary constructor can declare parameters that
 * the primary constructor does not have, and attributes can be
 * assigned values through the auxiliary constructor.
 * 1.4 Parameters can not be modified by var or val.
 */
class AuxiliaryConstructor {
  var name = "Allen"
  var age = 0

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, @BeanProperty age: Int) {
    this(name)
    this.age = age
  }
}

object AuxiliaryConstructor{
  def main(args: Array[String]): Unit = {
    val s1 = new AuxiliaryConstructor()
    val s2 = new AuxiliaryConstructor("Allen")
    val s3 = new AuxiliaryConstructor("Allen",18)
  }
}
