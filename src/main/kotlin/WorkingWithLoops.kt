import java.util.*

fun main (args: Array<String>) {
    println("FizzBuzz.....")
    for(i in 1..100) {
        print("${fizzBuzz(i)}")
    }
    println()

    for(i in 100 downTo 1 step 2) {
        print("${fizzBuzz(i)}")
    }

    println("Binary Representation...")
    binaryRepresentation()

    println("Foreach Collection with index...")
    iterateCollectionWithIndex()
    println("About 'in' operator...")
    println("is Q a letter? ${isLetter('Q')}")
    println("is X not a digit? ${isNotDigit('X')}")
    println("What is a T? ${recognize('T')}")

    println("Is Kotlin in Java..Scala? ${"Kotlin" in "Java".."Scala"}")
    println("But then is Kotlin in a set of Java and Scala? ${"Kotlin" in setOf("Java", "Scala")}")

    println("Speaking about exceptions...")
    tryAsExpression()
}

fun fizzBuzz(value: Int) =
        when {
            value % 15 == 0 -> "FizzBuzz "
            value % 3 == 0 -> "Fizz "
            value % 5 == 0 -> "Buzz "
            else -> "$value "
        }

fun binaryRepresentation() {
    val binaryReps = TreeMap<Char, String>()

    for(c in 'A' until 'Z' + 1) {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

fun iterateCollectionWithIndex() {
    val list = arrayListOf("10", "11", "1001")
    for((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter etter!"
    else -> "I don't know..."
}

fun tryAsExpression() {
    val number = try {
        Integer.valueOf("1986WRONG")
    } catch(e: NumberFormatException) {
        null
    }
    println("Number is: $number")
}

