package main.Scala.com.artists.scala

import main.Scala.com.artists.classobject.Bird

/**
 * [variable] match {
 * case "[Value_1]" => [Block_1] // no break statement
 * case "[Value_2]" => [Block_2]
 * case _ => [Block_n] // similar to default in Java
 * }
 *
 * 1. The express after case can be any type of constant, e.g.
 * String, Class, Tuple, Set, etc
 * 2. Unlike Java's switch, the match structure does not require a
 * break statement to exit the judgment;
 * 3. The final case statement uses the wild card "_", which is
 * equivalent to Java's default.
 * 4. If nothing match, it will report an error.
 */
class MatchTest {

}

object MatchTestObj {
  def main(args: Array[String]): Unit = {
    // 1. String match
    println("RES_1: ")
    val number = 1
    number match {
      case 1 => println("Start")
      case 2 => println("Running")
      case 3 => println("Stop")
      case _ => println("Invalid number")
    }

    // 2. return value
    println("RES_2: ")
    val name = "Allen"
    val age = 27
    val res: AnyVal = name match {
      case "Allen" if (age > 18) => 10000
      case "lisi" => 8000
      case _ => println("No this user")
    }
    println("res: " + res)

    // 3.Type match, Scala prefer to use match rather than isInstanceOf
    println("RES_3: ")
    val value: Any = 20
    value match {
      case x: Bird => println(x, "Bird")
      case x: Int if (x > 18) => println(x, "Int")
      case x: Int if (x > 18) => println(x, "Int_1")
      case _ => println("unknown type")
    }

    // 4. Array match
    println("RES_4: ")
    val arr = Array(1, 2, 3, 4)
    arr match {
      case x: Array[Int] => x.foreach(print)
      case Array(1, 2, 3, 4) => println(2)
      case Array(a, b, c, d) => println(a, b, c, d)
      case Array(a, b, _, _) => print(a, b)
      case _ => println("Nothing match")
    }

    // 5. Tuple match
    println()
    println("RES_5: ")
    val tp = (1, "Allen", 20)
    tp match {
      case (1, "Allen", 20) => println("1")
      case x: (Int, String, Int) => println(x)
      case (a, b, c) => println(a, b, c)
      case (a, b, _) => println(a, b)
      case _ => println("Nothing match")
    }

    // 6. List match
    println("RES_6: ")
    val list = List(1, 2, 3, 4)
    list match {
      case List(1, 2, 3, 4) => println("1")
      case x: List[Int] => println(x)
      case List(a, b, c, d) => println(a, b, c, d)
      case List(a, b, _, _) => println(a, b)
      case a :: b :: c :: d => println(a, b, c, d)
      case a :: b :: c :: d :: Nil => println(a, b, c, d)
      case _ => println("Nothing match")
    }

    // 7. Map match
    println("RES_7: ")
    val map = Map("Allen" -> 20, "Dan" -> 30)
    map.get("Allen") match {
      case Some(v) => println(v)
      case None => println("no value")
    }

    /**
     * PartialFunction[-A, +B] => receive A return B
     */
    // 8. Partial function match
    println("RES_8: ")
    def add:PartialFunction[(Int,Int),Int] = {
      case x => x._2 + x._2
    }
    println(add(1,2))

    arr.map({
      case x => x+1
    }).foreach(x => print(x + ","))

  }
}
