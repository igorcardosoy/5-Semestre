package exceptions.exer

fun divisao(a: Int, b: Int): Int? {
    return try {
        a.div(b)
    } catch (e: ArithmeticException) {
        null
    }
}

fun divisaoExpressao(a: Int, b: Int): Int? =
    try {
        a.div(b)
    } catch (e: ArithmeticException) {
        null
    }




fun main(){
    println(divisao(10, 0))

    println(divisaoExpressao(10, 5))
}