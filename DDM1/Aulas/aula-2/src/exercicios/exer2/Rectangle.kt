package exercicios.exer2

class Rectangle(
    val height : Double,
    val width: Double,
){
    val area: Double
        get() = height * width
}