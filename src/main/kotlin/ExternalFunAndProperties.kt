import hw.external.Button
import hw.external.View

fun View.showOff() = println("I'm a view! ${this.javaClass}")

fun Button.showOff() = println("I'm a button! ${this.javaClass}")

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) = setCharAt(length - 1, value)

fun main(args: Array<String>) {
    val view: View = Button()
    view.click()
    view.showOff()
    Button().showOff()

    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}