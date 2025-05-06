package view

import model.EstacionamentoDAO
import model.veiculo.Veiculo
import model.veiculo.VeiculoEnum
import java.time.Instant


fun menuPrincipal(): Int {
    println("1. Informar placa")
    println("2. Listar veículos")

    return readln().toInt()
}

fun menuRelatorios(): Int {
    println("1. Texto simples")
    println("2. HTML (tabela)")

    return readln().toInt()
}

fun solicitarPlaca(): String {
    println("Digite a placa: ")
    return readln()
}

fun cadastroVeiculo(placa: String): Veiculo {
    println("Placa: $placa")

    println("Digite a descrição: ")
    val descricao = readln()

    val tipo = tipoVeiculo()

    return Veiculo(
        placa,
        descricao,
        tipo,
        Instant.now()
    )
}

fun estacionamentoCheio(veiculo: VeiculoEnum?){
    when (veiculo) {
        VeiculoEnum.MOTO -> println("Estacionamento cheio para motos!")
        VeiculoEnum.CARRO -> println("Estacionamento cheio para carros!")
        else -> {
            println("Estacionamento cheio")
        }
    }
}

fun showString(string: String) {
    println(string)
}

fun saidaVeiculo(veiculo: Veiculo, preco: Double) {
    println("Veículo ${veiculo.placa} saiu do estacionamento")
    println("Tempo: ${veiculo.getSegundos()} horas(segundos).")
    println("Valor: ${veiculo.getPreco(preco)}")
}

fun tipoVeiculo(): VeiculoEnum {
    println("Selecione o tipo do veiculo.")
    println("1. Carro")
    println("2. Moto")

    return when (readln().toInt()) {
        1 -> VeiculoEnum.CARRO
        2 -> VeiculoEnum.MOTO
        else -> {
            tipoVeiculo()
        }
    }
}

