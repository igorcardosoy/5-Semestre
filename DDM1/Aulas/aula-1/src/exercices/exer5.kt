/*
Escreva um programa para calcular o Índice de Massa Corporal (IMC) de um indivíduo. Considere:
IMC=peso / altura×altura

Em seguida, mostre a classificação do IMC, conforme a seguir:

    Abaixo do peso: IMC menor que 18,5

    Eutrófico: IMC maior ou igual a 18,5 e menor do que 25,0

    Sobrepeso: IMC maior ou igual a 25,0 e menor do que 30,0

    Obesidade: IMC acima de 30,00
* */

package exercices


fun main() {
    print("Digite a sua Altura (m | Ex: 1.70): ")
    val altura = readln().toDouble()

    print("Digite o seu peso (kg | Ex: 65): ")
    val peso = readln().toDouble()

    val imc = peso / (altura * altura)

    when {
        imc > 30 -> println("Obesidade")
        imc >= 25 -> println("Sobrepeso")
        imc >= 18.5 -> println("Eutrófico")
        else -> println("Abaixo do peso")
    }
}
