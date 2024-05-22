/**
 * Groovy can be a OOP, and it can also be a script language.
 * 1. The following way is Groovy as a scripting language to create a groovy and write "Hello World"
 * You can see there are no classes in this way.
 * 2. You can also see HelloWorld_2.groovy, we define a class and a main(), and then to print "Hello
 * World".
 * 3. There can't be 2 same file name in same folder. E.g.
 * HelloWorld.groovy & HelloWorld -> it will report an error -> That's why here is HelloWorld_2
 * 4. You can define a script and a class in a same file.
 * e.g. class student
 * but you can't define a class with an exist file name
 * e.g. class HelloWorld_2{} or HelloWorld{} -> it will report an error
 * 5. Use def to define variables and methods in groovy, specific data types are not recommended.
 * 6. Comment -> same with Java, e.g. //
 * 7. The semicolon (;) at the end of the statement can be omitted
 * 8. Classes, methods, and fields are modified by public keyword by default.
 * 9. Object's properties operation
 *  Write:
 *  //Assign values to object properties
 *  [OBJECT].[PROPERTY_NAME] = [VALUE]
 *  The setter() of an object
 *  Constructor of groovy
 *
 *  Read:
 *  [OBJECT].[PROPERTY_NAME] -> stu.name
 *  [OBJECT]["[PROPERTY_NAME]"] -> stu["name"]
 *  The getter() of an object
 * 10. The properties of a class will use getter() and setter() to read and write.
 * 11. Groovy supports sequential structure, branch structure, and loop structure.
 * 12. Groovy supports various operations.
 * 13. Basic types are objects in Groovy, it can call objects’ methods
 * 14. There are single quotes, double quotes, and triple quotes in Groovy.
 * ’’ → Only a string, can not perform calculations
 * ”” → Quotable variables ${}, can perform calculations
 * ’’’ ‘’’ → Template string
 *
 */
print("Hello World")

// 4.
//class HelloWorld{}

// 5.
class Student{
    def name // recommend
    String gender // not recommend

    // Recommend
    public def getName(){
    }

    // Not recommend
    public String getGender(){
    }


}

