def obj = new Demo01BasicNotice()
println(obj.getBookName())
println(obj.sale(10))

// No.5
def rs = obj.sale 100
println(rs)
// You can use this way
// println(obj.sale 100)

// No.7
obj.bookName = "Groovy Study Note2"
println(obj.bookName)
obj["bookName"] = "Groovy Study Note3"
println(obj.bookName)
obj.setBookName("Groovy Study Note4")
println(obj.bookName)
def obj_2 = new Demo01BasicNotice(bookName: "Groovy Study Note5")
println(obj_2.getBookName())
def obj_3 = new Demo01BasicNotice(description: "Description_2",bookName: "Groovy Study Note6")
println(obj_3["description"] + " " + obj_3.getBookName())
