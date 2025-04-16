/*
* Escreva um programa que calcule e mostre a área de um círculo de raio r
* */

package exercices

import kotlin.math.pow

const val PI = 3.14159

fun main() {
    print("Digite o raio de círculo: ")
    val raio = readln().toDouble()

//    println("A area do círculo é de ${Math.PI * raio.pow(2)}")

    println("A area do círculo é de ${PI * raio.pow(2)}")
}