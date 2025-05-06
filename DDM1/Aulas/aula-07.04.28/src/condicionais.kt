fun teste(preco: Double): Double {
    return if (preco > 100) {
        0.90 * preco
    } else {
        0.75 * preco
    }
}

fun main() {
    val preco: Double = 200.0

    println("Preço atual: ${teste(preco)}")
}

