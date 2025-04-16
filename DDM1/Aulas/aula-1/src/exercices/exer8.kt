/*
* Defina uma função chamada menor(), que receba dois números inteiros como argumentos e retorne o valor do menor deles.
* */

package exercices

fun menor(a: Int, b: Int): Int {
    return if (a <= b) a else b
}

fun main() {

    print("Digite um número: ")
    val num1: Int = readln().toInt()

    print("Digite outro número: ")
    val num2: Int = readln().toInt()

    println("O número menor é o ${menor(num1, num2)}")
}

