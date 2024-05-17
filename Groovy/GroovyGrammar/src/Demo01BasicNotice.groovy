/**
 * 1. Groovy use def to define properties, and methods. def
 * support dynamic type declaration.
 * 2. Single line comments -> //
 * Multi-line comments -> /**
 * 3. The ; at the end of Groovy statement can be omitted.
 * 4. Groovy can generate getter() and setter() for properties
 * automatically.
 * 5. Method Declaration: parameters type, return type, and
 * return keyword can be omitted. The () can be omitted when
 * call a method, if it is unambiguous.
 * 6. Variable reference: {} can also be omitted if it is
 * unambiguous.
 * 7. Write properties:
 *  1. stu.name =
 *  2. stu["name"] =
 *  3. stu.setName()
 *  4. constructor
 *  e.g. def obj = new Object(bookname: "Note Book")
 *
 *  Read properties:
 *  1. stu.name
 *  2. stu["name"]
 *  3. stu.getName()
 */
class Demo01BasicNotice {
    def description = "Description"
    def bookName = "Groovy Study Note"

    // No.5 No.6
    def sale(price){
        println("The book is ${price}")
        "The book is $price"
    }
}
