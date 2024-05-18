// List
def list = [1, "2", 3, 4, true]
assert list instanceof java.util.List
println("Original list: " + list.toString())

list.add(5)
println("After add(5): " + list.toString() + " Size: " + list.size())

def list_2 = [1, 6, 7]
def list_com = list.plus(list_2)
println("After plus(list_2): " + list_com.toString())

list_com.removeElement(1) // Only remove the first matched element
println("After removeElement(1): " + list_com.toString())

list_com.remove(0) // remove([INDEX])
println("After remove(0): " + list_com.toString())
list_com.removeAll(list_2)
println("After removeAll(list_2): " + list_com.toString())

def list_com_pop = list_com.pop()
println("After pop(): " + list_com_pop)

list_com.putAt(0, 1) // putAt([INDEX],[VALUE])
println("After putAt(1,0): " + list_com)

list_com.each ({println("Item: ${it}")})

println("After contains(): ${list_com.contains(5)}")







