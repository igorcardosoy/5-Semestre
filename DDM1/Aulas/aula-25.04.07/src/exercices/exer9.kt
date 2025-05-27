/*
* Escreva um programa que leia um número correspondente a um ano e indique se o ano é bissexto.
* Um ano é bissexto se for múltiplo de 4 e não for múltiplo de 100, ou se for múltiplo de 400.
* */

package exercices


fun main() {

    print("Digite um ano (Ex: 2005): ")
    val year: Int = readln().toInt()

    if (year % 4 == 0) {
        if (year % 100 == 0) {
            if (year % 400 == 0) println("$year é um ano bissexto!!")
            else println("$year não é ano bissexto :(")
        } else println("$year é um ano bissexto!!")
    } else println("$year não é ano bissexto :(")
}
