/*
* Escreva um programa para converter uma medida de metros para milímetros.
* */


package exercices


fun main() {
    print("Digite uma medida (em metros): ")
    val medida: Double = readln().toDouble()

    println("Medida em milímetros: ${medida * 1000}mm")
}
