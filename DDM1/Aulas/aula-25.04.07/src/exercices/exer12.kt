/*
* Defina uma função que calcule o fatorial de um número não-negativo n
* */

package exercices

fun main(){
    println("---Calcular Fatorial---")

    print("Digite um numero (> 0): ")
    val num: Int = readln().toInt()

    if (num < 0) println("Número inválido")
    else println("O fatorial de $num é ${fatorial(num)}")
}

fun fatorial(num: Int): Int{
    return if (num == 0) 1
    else num * fatorial(num - 1)
}