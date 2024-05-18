
// Map
def map = [J:"Java", 'G':"Groovy", "S":"Scala"]
println("Initial map -> ${map.toString()}")

map.put("P","Python")
println("After put(\"P\",\"Python\") -> ${map.toString()}")

map.remove("P")
println("After remove(\"P\") -> ${map.toString()}")

map.remove("J", "Java")
println("After remove(\"J\", \"Java\") -> ${map.toString()}")

map - [S:"Scala"]
println("After map - [S:\"Scala\"] -> ${map.toString()}")
def map_2 = map - [S:"Scala"]
println("After map - [S:\"Scala\"] -> ${map_2.toString()}")
map + [G:"Gradle"]
println("After map + [G:\"Gradle\"] -> ${map.toString()}")
def map_3 = map + [G:"Gradle"]
println("After map + [G:\"Gradle\"] -> ${map_3.toString()}")

map_3.each ({
    key, value -> {
        println("key -> ${key}, value -> ${value}")
    }
})

map_3.each ({
    entry -> {
        println("key -> ${entry.key}, value -> ${entry.value}")
    }
})
