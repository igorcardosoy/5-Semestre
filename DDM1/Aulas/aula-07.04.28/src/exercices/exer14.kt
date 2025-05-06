/*
* O hodômetro é um equipamento que serve para medir a distância percorrida
* por um veículo ou o número de quilômetros percorridos desde sua fabricação.
* Os hodômetros de veículos antigos tinham apenas 5 dígitos e indicavam, no máximo, 99.999 Km,
* voltando então a marcar 00.000, quando o veículo percorresse mais um quilômetro.
* Considere um veículo simples, cujo hodômetro possa indicar apenas 2 dígitos (até 99 Km).
* Escreva um programa que mostre todas as leituras desse um hodômetro, desde a fabricação do veículo,
* quando este já tiver percorrido 320 Km.
* */

package exercices

fun main() {
    println("---HODÔMETRO---")

    val dist = 320
    val hodometro: Hodometro = Hodometro(0)

    for (i in 0 .. dist) {
        hodometro.percorrerUmKm()
        println("${hodometro.getdistPercorrida()} km")
    }
}

class Hodometro (private var distPercorrida: Int){

    fun percorrerUmKm(){
        distPercorrida++

        if (distPercorrida > 99) {
            distPercorrida = 0
        }
    }

    fun getdistPercorrida(): Int {
        return distPercorrida
    }
}



