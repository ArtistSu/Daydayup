package main.Scala.com.artists.classobject

/**
 * 1. trait can include abstract and non-abstract members, this is similar to abstract
 * class in Scala. But you don't need to use abstract keyword.
 * 2. If you want to override the method in trait, you don't need to use override keyword.
 * 3. You should use extend keyword no matter you extend to Trait or Abstract class.
 * 4. If you extend a trait with any abstract members, you must implement them or override them.
 * 5. If you want to extends more class, you must extends first one and use with keyword for the others.
 * e.g. class_t1 extends t2 with t3 with t4
 * 6. trait can't create by new [traitName]
 */
trait Market{
  // define common property
  val name:String = "market"

  // define abstract property
  val maxPrice:Int

  // define common method
  def description = {
    println("This is a common method in fly trait.")
  }

  // define abstract method
  def action():Unit
}


class Bird extends Market{

  // override abstract property
  val maxPrice:Int = 1000

  // override non-abstract property
  override val name: String = "fire bird"

  // override non-abstract method
  override def description(): Unit = {
    println("This is a bird class extends Market trait")
  }

  // override abstract member
  override def action(): Unit = {
    println("There is a bird will be sold")
  }
}

object TraitTest{
  def main(args: Array[String]): Unit = {
    val bird = new Bird
    bird.description()
  }
}
