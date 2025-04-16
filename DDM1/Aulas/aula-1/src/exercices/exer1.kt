/*
* Escreva um programa some dois números inteiros, lidos do teclado, e mostre o resultado na tela.
* */

package exercices

fun main() {
    print("Digite um número: ")
    val num1 = readln().toInt()

    print("Digite outro número: ")
    val num2 = readln().toInt()

    println("Soma: ${num1 + num2}")
}