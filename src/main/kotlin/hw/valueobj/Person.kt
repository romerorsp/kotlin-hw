package hw.valueobj

// name is immutable, with getter, no setter. (val)
// isMarried is mutable, with getter and setter. (var)
class Person (val name: String, var isMarried: Boolean) {
    val nameSize: Int
        get() = name.length
}