package main.Scala.com.artists.classobject

/**
 * 1. Attribute, method, function can put in the class
 * 2. The definition of attributes in a class is the same as
 * the definition of variables, you can use val(immutable) or
 * var(mutable).The default permission is public.
 * 3. Methods in a class are defined with the keyword def.
 * 4. Object also called singleton object, is a static member
 * after compilation. If there is a class with the same name
 * as the object, the object is called a companion object of
 * the class. Correspondingly, the class is a companion class
 * of the object.
 * 5. There no set() get() in a class.
 */
class Student {
  var name = "Allen"
  var age = 20

  def sayHello(): Unit = {
    println("hello",name)
  }

  override def toString(): String = {
    "name = " + name + " age " + age
  }
}

object TestStudent{
  def main(): Unit = {
    val student = new Student
    student.age = 30
    student.name = "lisi"
    println(student.name)
    student.sayHello()
  }
}
