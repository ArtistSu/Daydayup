package com.artists.scala

import java.io.File

/**
 * Definition: def [MethodName]([Parameter]:[Type]):[ReturnType]{...}
 * Calling methods:
 *  - Normal Call
 *  - Infix Call
 *  - Big Bracket Call
 *
 *  Variable Parameters Method
 */
object MethodTest {

  def add(x: Int, y: Int): Int = {
    x + y
  }

  def main(args: Array[String]): Unit = {
    println(add(100, 200))

    // Normal call
    Util.SayHello_Parametric("ArtistS")

    // Infix call
    Util SayHello_Parametric "ArtistS"

    // Big bracket call, only 1 parameter can be used
    Util SayHello_Parametric {
      "ArtistS"
    }

    // Recursive call
    val num = 3
    println("Factorial " + num + " is " + Util.factorial(num))

    val pathTest = "C:\\GitRepository\\Daydayup\\Scala\\ScalaGrammar"
    Util.listFiles(pathTest)

    // Variable Parameters Method
    def sum(x:Int*): Int = {
      var sum = 0
      for(i:Int <- x){
        sum += i
      }
      sum
    }

    println("Variable Parameters - " + sum(1,2))
    println("Variable Parameters - " + sum(1,2,3))

    def sum_2(x:Int,y:Int*): Int = {
      var sum = 0
      for(i:Int <- y){
        sum += i
      }
      x * sum
    }
    println("Variable Parameters 2.0 - " + sum_2(2,3))
    println("Variable Parameters 2.0 - " + sum_2(2,3,4))
  }

}

object Util {
  def SayHello(): Unit = {
    println("Say Hello")
  }

  def SayHello_Parametric(name: String): Unit = {
    println("Say Hello " + name)
  }

  def SayHello_Parametric_Return(name: String): Unit = {
    "Say Hello " + name
  }

  def factorial(number: Int): Int = {
    if (number == 1) {
      1
    } else {
      number * factorial(number - 1)
    }
  }

  def listFiles(path: String): Unit = {
    val file = new File(path)
    if (file.isFile) {
      println(file.getPath)
    } else {
      val list = file.list()
      for (subFile: String <- list) {
        listFiles(path + "/" + subFile)
      }
    }
  }
}
