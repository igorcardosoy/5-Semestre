val sub: (Int, Int) -> Int = {a, b -> a - b}
//val somar: (Int, Int) -> Int = {a, b -> a + b}
val mult = {a: Int, b: Int -> a * b}
val fazNadaDeUtil = {msg: String -> println(msg)}

fun executar(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    val res = op(a, b)
    return res
}

fun main() {
    val res = mult(5,2)
    println(res)

    val total = executar(2, 6) { a, b ->
        if (a > 5) a - b
        a + b
    }

    println(total)
}