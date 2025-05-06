package model

import java.time.Duration
import java.time.Instant

class Veiculo(
    val placa: String,
    val descricao: String,
    val tipo: VeiculoEnum,
    val entrada: Instant
){
    fun getSegundos() : Long {
        val horaAtual = Instant.now()
        val tempoUtilizado = Duration.between(entrada, horaAtual)

        return tempoUtilizado.toSeconds()
    }
}