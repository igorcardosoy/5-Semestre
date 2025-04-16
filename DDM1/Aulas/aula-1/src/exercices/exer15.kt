/*
* Defina uma função que receba um número inteiro e retorne verdadeiro se ele for primo.
* */

package exercices

fun main(){
    print("Digite o número que quer descrobrir se é primo: ")
    val num = readln().toInt()

    if (isPrimeNumber(num)) println("É número primo!!")
    else println("Não é número primo!!")
}

fun isPrimeNumber(num: Int): Boolean {
    for (i in 2 ..< num) {
        if (num % i == 0) return false
    }

    return true
}