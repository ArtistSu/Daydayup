/**
 * Grammar: {[closureParameters ->] statements}
 * Examples:
 * {item++} // Closure with parameters item
 * {-> item++} // Closure without parameters
 * {println it} // No specific parameter, it will use it as parameter
 * {name -> println name} // Provide a specific parameter
 * {String x, int y -> println "hey ${x} the value is {y}"} // Multiple parameters
 * {reader -> // Parameter can be object, and one closure can also has several statements
 *  def line = reader.readline()
 *  line.trim()
 *  }
 *
 *  How to call a closure
 *  Step1: Assign a closure to a variable
 *  Step2: [VariableName]()  or [VariableName].call()
 */

def flying = {
    println("flying start...")
    println("flying end...")
}

def study = {
    who ->
        println("${who} is studying")
        println("${who} finish study")
}

// How to call a closure
flying()
flying.call()

study("Allen")
study.call("Allen")

// In dev work we will use closure as a parameter
def running(Closure closure) {
    println("running start")
    closure()
    println("running end")
}

running({println("running")})

def calculate(Closure closure){
    def num1 = 10
    def num2 = 20
    closure(num1,num2)
}

calculate ({k,v -> println("${k}+${v} = ${k+v}")})

def calculate_2(num1,num2,Closure closure){
    closure(num1,num2)
}
calculate_2(10,20,{k,v -> println("${k}+${v} = ${k+v}")})

// If the closure is the last parameter of a method, you can write the closure outside the method
calculate_2(10,20){k,v -> println("${k}+${v} = ${k+v}")}
