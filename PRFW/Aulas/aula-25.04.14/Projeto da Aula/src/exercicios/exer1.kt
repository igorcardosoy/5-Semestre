package exercicios

fun Int.isEven() = this % 2 == 0

fun main() {
    println(4.isEven())
    println(5.isEven())
}