package enums.exer

enum class NiveisPerigo {
    BAIXO,
    MEDIO,
    ALTO;
}

fun getMessage(niveisPerigo: NiveisPerigo) {
    when (niveisPerigo) {
        NiveisPerigo.BAIXO -> "Fuja para as colinas"
        NiveisPerigo.MEDIO -> "Cuidado! Monitore os niveis de radiação."
        NiveisPerigo.ALTO -> "Fuja para as colinas!"
    }
}

fun main() {
    val perigo: NiveisPerigo = NiveisPerigo.ALTO
    print(getMessage(perigo))
}