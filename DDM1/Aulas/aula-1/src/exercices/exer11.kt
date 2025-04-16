/*
* Defina uma função que receba um número inteiro como argumento e retorne o dia da semana correspondente
* (1: domingo, 2: segunda-feira, etc.). Se o valor recebido estiver fora do intervalo de 1 a 7, a função deve
* lançar uma exceção contendo a mensagem número inválido.
* */

package exercices



fun main() {
    print("Digite um dia da semana (Entre 1-7): ")
    val day: Int = readln().toInt()

    println("O dia é ${getDayInString(day)}")
}

fun getDayInString(day: Int): String{
    return when(day){
        1 -> "Domingo"
        2 -> "Segunda-feira"
        3 -> "Terça-feira"
        4 -> "Quarta-feira"
        5 -> "Quinta-feira"
        6 -> "Sexta-feira"
        7 -> "Sábado"
        else -> {throw RuntimeException("Número inválido!")}
    }
}