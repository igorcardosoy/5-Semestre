/*
*
Escreva um programa que receba duas notas parciais de um aluno. O programa deve calcular a média alcançada pelo aluno e apresentar a mensagem:

    Aprovado, se a média for maior ou igual a 6,0;

    Reprovado, se a média for menor do que 6,0.

O programa também deve mostrar a média calculada.
* */

package exercices

fun main() {
    print("Digite a nota 1: ")
    val nota1 = readln().toDouble()

    print("Digite a nota 2: ")
    val nota2 = readln().toDouble()

    val media = (nota1 + nota2) / 2

    when {
        media < 6 -> println("Reprovado com a média $media :(")
        else -> println("Aprovado com a média $media :)")
    }
}