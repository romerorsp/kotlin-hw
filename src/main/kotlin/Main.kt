import hw.valueobj.Color
import hw.valueobj.Person
import hw.valueobj.Color.*

fun main(args: Array<String>) {
    chapterOne()

    chapterTwo()
}

fun chapterTwo() {
    val color = Color.BLUE.rgb()
    println("Picking the BLUE color: $color")
    println("And here's the mnemonic for the BLUE color: ${getMnemonic(Color.BLUE)}")
    println("How about warmth? ORANGE is a ${getWarmth(Color.ORANGE)} color")
    println("The mix of BLUE and YELLOW results in ${mix(Color.BLUE, Color.YELLOW)}")
    println("What happens when I mix VIOLET and BLUE? ${mixOptimised(VIOLET, BLUE)}")
    println("And how about mixing BLUE and VIOLET? ${mixOptimised(BLUE, VIOLET)}")
}

fun chapterOne() {
    var world = expressionBody(5)
    val helloWorld = "Hello, $world"
    println(helloWorld)

    world = expressionBody(100)
    // val keeps being immutable whereas var is always mutable
    val helloBigWorld = "Hello, $world"
    println(helloBigWorld)

    val helloStrangeWorld = "Hello, strange, the word world has ${if (world.length > 10) "more than 10" else "less or equal to 10"} characters!"
    println(helloStrangeWorld)

    val person = Person("Rômero", false)
    person.isMarried = true

    println("Hello ${person.name}, I know you're ${if (person.isMarried) "for sure" else "not"} married. Your name is sized [${person.nameSize}]")
}

fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix(color1: Color, color2: Color) =
        when (setOf(color1, color2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty Color")

        }

fun mixOptimised(color1: Color, color2: Color) =
        when {
            (color1 == RED && color2 == YELLOW) ||
            (color2 == RED && color1 == YELLOW) -> ORANGE
            (color1 == YELLOW && color2 == BLUE) ||
            (color2 == YELLOW && color1 == BLUE) -> GREEN
            (color1 == VIOLET && color2 == BLUE) ||
            (color2 == VIOLET && color1 == BLUE) -> INDIGO
            else -> throw Exception("Dirty color")
        }

fun expressionBody(value: Int) = if (value < 10) "world!" else "big world!"
