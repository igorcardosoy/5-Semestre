/*
* Defina uma função isLeapYear(year) que retorne verdadeiro quando um ano for bissexto e falso em caso contrário.
* */

package exercices


fun main() {

    print("Digite um ano (Ex: 2005): ")
    val year: Int = readln().toInt()

    if (isLeapYear(year)) println("$year é um ano bissexto!!")
    else println("$year não é ano bissexto :(")
}

fun isLeapYear(year: Int): Boolean{
    return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)
}
