package main.Scala.com.artists.classobject

/**
 * apply
 * 1. Define apply() in a companion object of a class. When
 * generating an object of this class, the new keyword is omitted.
 * 2. The parameters of apply() does no need to be consistent with
 * the parameters of constructor, which means apply() supports
 * overloading.
 * 3. apply() can create object by primary constructor and auxiliary
 * constructor.
 * 4. The apply() is defined in object to create the object; if
 * defined in class, it is to obtain the data of the object
 */
class Cat (val name: String, val age: Int) {
  def apply(i: Int) = {
    if (i == 0) {
      this.name
    } else if (i == 1) {
      this.age
    } else {
      "invalid index"
    }
  }
}

object Cat {
  var cat: Cat = _
  def apply(name: String, age: Int): Cat = {
    if (cat == null) {
      cat = new Cat(name, age)
    }
      cat
  }

}

object TestCat{
  def main(args: Array[String]): Unit = {
    val cat = new Cat("Allen",1)
    val cat_1 = Cat.apply("Allen",2)
    val cat_2 = Cat("Allen",3)
    println(cat)
    println(s"Name:${cat.name},Age:${cat.age}")
    println(cat_1)
    println(s"Name:${cat_1.name},Age:${cat_1.age}")
    // Already a cat object in object Cat, so the
    // address of cat_1 and cat_2 is same
    println(cat_2)
    println(s"Name:${cat_2.name},Age:${cat_2.age}")

    // Call the apply() in class Cat
    println(cat_2(1))
  }
}