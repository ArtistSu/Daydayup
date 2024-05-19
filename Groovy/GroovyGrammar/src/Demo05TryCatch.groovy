import groovy.console.ui.AstBrowser

// try-catch
try {
    'moo'.toLong()   // this will generate an exception
    assert false     // asserting that this point should never be reached
} catch ( e ) {
    assert e in NumberFormatException
    println("This is a NumberFormatException")
}

// try-finally
def z
try {
    def i = 7, j = 0
    try {
        def k = i / j
        assert false        //never reached due to Exception in previous line
    } finally {
        z = 'reached here'  //always executed even if Exception thrown
    }
} catch ( e ) {
    assert e in ArithmeticException
    assert z == 'reached here'
    println("This is an ArithmeticException and z -> ${z}")
}

// multi-catch
try {
    (new noPointer())["pointer_2"]
} catch ( IOException | MissingPropertyException e ) {
    println("This is a MissingPropertyException")
}

class noPointer{
    def pointer
}