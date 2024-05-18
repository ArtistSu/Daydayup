/**
 * 1. ' : Don't support variable reference or line feed operation.
 * 2 "" : Support variable reference, but don't support line feed operation.
 * 3 ''': Template string, don't support variable reference, support line
 * feed operation.
 */

def description = "Test"

def str_1 = 'Single Quote ${description}'
def str_2 = "Double Quote ${description}"
def str_3 = '''Triple Quote 
${description}'''

println("str_1: " + str_1)
println("str_2: " + str_2)
println("str_3: " + str_3)

println(str_1.getClass().toString())
println(str_2.getClass().toString())
println(str_3.getClass().toString())
