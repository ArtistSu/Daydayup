import groovy.xml.MarkupBuilder

import java.text.SimpleDateFormat

//  Manually import
def builder = new MarkupBuilder()
assert builder != null

/**
 * Automatically import -> there is not explicit import
 * Date packages. Caz Groovy will default import
 * import java.lang.*
 * import java.util.*
 * import java.io.*
 * import groovy.lang.*
 * import groovy.util.*
 * import java.math.BigInteger
 * import java.math.BigDecimal
 */
def sdf = new SimpleDateFormat()
println(sdf.format(new Date()))