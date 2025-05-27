/*
* Escreva um programa que calcule e mostre a tabuada de um número digitado pelo usuário.
* */

package exercices

fun main(){
    print("Digite um número: ")
    val num: Int = readln().toInt()

    println("---TABUADA---")
    for (i in 0..10) {
        printTabuada(num, i)
    }

}

fun printTabuada(num: Int, mult: Int) {
    println("$num x $mult = ${num.times(mult)}")
}