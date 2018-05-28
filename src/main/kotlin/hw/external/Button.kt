package hw.external

class Button : View() {
    override fun click() = println("${this.javaClass} - Button clicked")
}
