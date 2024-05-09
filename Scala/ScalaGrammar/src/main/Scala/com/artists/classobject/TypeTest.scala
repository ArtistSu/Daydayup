package main.Scala.com.artists.classobject

/**
 * 1. type can set a alias for a complex type name
 */
class TypeTest {

    type alias_type = (Int,String,Int,String,String)
    val tmp:alias_type = (1,"2",3,"4","5")

    type myListtype = scala.collection.immutable.List[Int]
    val list:myListtype = List[Int](1,2,3,4,5,6)
}
