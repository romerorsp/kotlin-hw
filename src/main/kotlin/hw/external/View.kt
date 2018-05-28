package hw.external

open class View {
    open fun click() = println("${this.javaClass} - View clicked")
}