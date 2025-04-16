class Retangulo(
    val largura: Int,
    val altura: Int
) {

    val isQuadrado: Boolean
        get() = largura == altura
}

fun main(){
    val r1 = Retangulo(4, 2)
    println(r1.isQuadrado)
}