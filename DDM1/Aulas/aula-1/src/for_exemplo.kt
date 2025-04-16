import java.util.Optional

fun main() {
    val frutas = listOf("banana", "pera", "tomate", "acerola", "jaboticaba")

    for(f in frutas) {
        println(f)
    }

    for (i in 0 .. frutas.size) {
        println("aa")
    }

    for (i in 0 ..< frutas.size) {
        println("aa")
    }

    for (i in frutas.indices) {
        println("aa")
    }

    val teste: Number? = null

    println(teste)
}