import kotlin.random.Random


fun main() {
    val x = Random.nextInt()

    when (x) {
        1 -> print("x -= 1")
        2 -> print("x -= 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    when {
        x < 1 -> print("x -= 1")
        x < 22 -> print("x -= 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    val codigo = Random.nextInt(1, 5)
    val nome = when (codigo) {
        1 -> "Maria"
        2 -> "João"
        3 -> "Bruxa"
        4 -> "Trouxa"
        else -> "Otario"
    }

    println(nome)
}