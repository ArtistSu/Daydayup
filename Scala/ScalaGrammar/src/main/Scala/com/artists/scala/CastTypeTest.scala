package com.artists.scala

/**
 * Byte Short Int Long Float Double String has convenient cast
 * method, but Any must use asInstanceOf.
 */
object CastTypeTest {
  def main(args: Array[String]): Unit = {
    val b:Byte = 1
    val i:Int = 1
    val c:Any = 123

    // 1.Byte -> Int
    println("Byte -> Int: " + b.toInt + ", type: " + b.toInt.getClass.getSimpleName)

    // 2. Byte -> Long
    println("Byte -> Long: " + b.toLong + ", type: " + b.toLong.getClass.getSimpleName)

    // 3. Byte -> String
    println("Byte -> String: " + b.toString + ", type: " + b.toString.getClass.getSimpleName)

    // 4. Byte -> Float
    println("Byte -> Float: " + b.toFloat + ", type: " + b.toFloat.getClass.getSimpleName)

    // 5.Int -> Byte
    println("Int -> Byte: " + i.toByte + ", type: " + i.toByte.getClass.getSimpleName)

    // 6. Any -> Int
    println("Any -> Int: " + c.asInstanceOf[Int] + ", type: " + c.asInstanceOf[Int].getClass.getSimpleName)

  }
}
