package exercicios

val Double.milesToKm
    get() = this * 1.6

fun main() {
    println(5.0.milesToKm)
}