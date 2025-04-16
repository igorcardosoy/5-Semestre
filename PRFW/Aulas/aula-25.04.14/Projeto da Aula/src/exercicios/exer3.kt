package exercicios

import java.util.*

val Date.weekday
    get() = when (this.day) {
        0 -> "Domingo"
        1 -> "Segunda-feira"
        2 -> "Terça-feira"
        3 -> "Quarta-feira"
        4 -> "Quinta-feira"
        5 -> "Sexta-feira"
        6 -> "Sábado"
        else -> "Dia inválido"
    }

fun main() {
    val date = Date("26/10/2025")

    println(date.weekday)
}