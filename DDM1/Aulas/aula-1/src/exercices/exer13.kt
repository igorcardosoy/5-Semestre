/*
* Escreva um programa que mostre na tela os 10 primeiros termos da série de Fibonacci. \
* Os dois primeiros termos da série são os valores 1 e 1.
* O terceiro termo e os próximos são calculados como a soma dos dois termos anteriores.
* */

package exercices


fun main(){
    println("---FIBONACCI---")

    for (i in 0..< 10) {
        print("${fibonacci(i)} ")
    }
}

fun fibonacci(n: Int): Int {
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}