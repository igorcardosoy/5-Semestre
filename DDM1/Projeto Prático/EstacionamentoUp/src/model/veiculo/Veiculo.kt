package model.veiculo

import java.time.Duration
import java.time.Instant
import kotlin.math.ceil

class Veiculo(
    val placa: String,
    val descricao: String,
    val tipo: VeiculoEnum,
    val entrada: Instant
){
    fun getSegundos(): Long {
        val horaAtual = Instant.now()
        val tempoUtilizado = Duration.between(entrada, horaAtual)

        return tempoUtilizado.toSeconds()
    }

    fun getPreco(tipoPreco: Double): Double {
        val horas = ceil(getSegundos().toDouble() / 10)
        return horas * tipoPreco
    }
}