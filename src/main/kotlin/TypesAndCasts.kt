fun main(args: Array<String>) {
    val result = eval(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4)))
    println("The sum of the expression (1 + 2) + 4 is $result")
    val resultWithWhen = evalWithWhen(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4)))
    println("The sum of the expression with WHEN (1 + 2) + 4 is $resultWithWhen")


    val resultWithLogging = evalWithLogging(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4)))
    println("The sum of the expression with LOGGING (1 + 2) + 4 is $resultWithLogging")
}


sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}


fun eval(e: Expr): Int =
        if (e is Expr.Num) e.value
        else if (e is Expr.Sum) eval(e.right) + eval(e.left)
        else throw IllegalArgumentException("Unknown expression")

fun evalWithWhen(e: Expr): Int =
        when (e) {
            is Expr.Num -> e.value
            is Expr.Sum -> evalWithWhen(e.right) + eval(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Expr.Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Expr.Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }