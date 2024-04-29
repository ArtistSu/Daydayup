package main.Scala.com.artists.classobject

/**
 * Unapply
 * 1. unapply() is a reverse operation of apply(), apply() use
 * parameters to create an object, unapply() accept an object and
 * extract the value of it.
 * 2. unapply() usually called extraction method, unapply() will
 * return an Option object, and internally create a Some object.
 * 3. unapply() doesn't support overloading.
 * 4. unapply() is usually used for fuzzy matching.
 * 5. The number of generics in Option object affects the number of
 * Some's parameters returned by the unapply() and the number of case
 * type parameters in pattern matching.
 */
class Dog(val name: String, val age: Int) {
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

object Dog {
  var dog: Dog = _

  def apply(name: String, age: Int): Dog = {
    if (dog == null) {
      dog = new Dog(name, age)
    }
    dog
  }

  def unapply(dog: Dog): Option[(String, Int)] = {
    Some(dog.name, dog.age)
  }
}

object TestDog {
  def main(args: Array[String]): Unit = {
    // Will call unapply() to extract name and age
    val Dog(name,age) = Dog.apply("Allen",18)
    println(name,age)

    val dog  = Dog.apply("Allen_2",19)
    dog match {
      // dog is an object of Dog, so we can use x.name to get name
      case x:Dog => println(s"dog_name:${x.name}, dog_age:${x.age}")
      case Dog(x) => println(s"dog_name_1:${x._1}, dog_age_1:${x._2}")
      // Same with Dog(name,age), try to understand tip 5
      case Dog(x,y) => println(s"dog_name_2:${x}, dog_age_2:${y}")
      case Dog("Allen_2",y) => println(s"dog_name_3:Allen_2, dog_age_3:${y}")
    }
  }
}
