/*
* Escreva um programa que converta uma temperatura de graus Celsius (C) para Fahrenheit (F).
* */

package exercices

fun main() {
    print("Digite uma temperatura em graus Celsius (C): ")
    val temperature = readln().toDouble()

    println("${temperature}ºC em Fahrenheit são ${32 + ((9 + temperature) / 5)}ºF")
}