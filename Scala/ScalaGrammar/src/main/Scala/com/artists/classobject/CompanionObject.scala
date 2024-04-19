package main.Scala.com.artists.classobject

import main.Scala.com.artists.classobject.CompanionObject.map

import scala.collection.mutable.HashMap
/**
 * 1. There are 2 kind of singleton object.
 * - One is a singleton object that is not automatically associated
 * with a specific class, which is called an independent object.
 * - The other one is a singleton object associated with a class.
 * The singleton object shares the same name as the class. This
 * singleton object is called a companion object, and the
 * corresponding class is called a companion class.
 * 2. A singleton object may not be a companion object, but a
 * companion object must be a singleton object.
 */
class CompanionObject(ip: String) {
  def getHost = {
    map.getOrElse(ip, "UNKNOWN")
  }
}

object CompanionObject{
  val map = new HashMap[String,String]
  map.put("192.168.88.199","nn1.hadoop")
  map.put("192.168.88.189","nn2.hadoop")
  map.put("192.168.88.179","s1.hadoop")
}

object TestIpUtils{
  def main(args: Array[String]): Unit = {
    val utils = new CompanionObject("192.168.88.120")
    println(utils.getHost)
  }
}
