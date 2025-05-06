package model

import model.veiculo.Veiculo
import model.veiculo.VeiculoEnum

object EstacionamentoDAO {
    val motos = mutableListOf<Veiculo>()
    val carros = mutableListOf<Veiculo>()
    private const val CAPACIDADE_CARROS = 2
    private const val CAPACIDADE_MOTOS = 2
    private const val PRECO_CARRO_HORA = 5.0
    private const val PRECO_MOTO_HORA = 2.0

    fun getPrecoByTipo(tipo: VeiculoEnum): Double {
        return when(tipo){
            VeiculoEnum.CARRO -> PRECO_CARRO_HORA
            VeiculoEnum.MOTO -> PRECO_MOTO_HORA
        }
    }

    private fun getListaDoVeiculo(tipo: VeiculoEnum): MutableList<Veiculo> {
        return when(tipo){
            VeiculoEnum.CARRO -> carros
            VeiculoEnum.MOTO -> motos
        }
    }

    fun isCheio(tipo: VeiculoEnum): Boolean {
        return when (tipo) {
            VeiculoEnum.CARRO -> getListaDoVeiculo(tipo).size == CAPACIDADE_CARROS
            VeiculoEnum.MOTO -> getListaDoVeiculo(tipo).size == CAPACIDADE_MOTOS
        }
    }

    fun getVeiculo(placa: String): Veiculo? {
        return getVeiculoDaLista(carros, placa)
            ?: getVeiculoDaLista(motos, placa)
    }

    private fun getVeiculoDaLista(veiculos: List<Veiculo>, placa: String): Veiculo? {
        for (veiculo in veiculos)
            if (veiculo.placa == placa)
                return veiculo

        return null
    }

    fun addVeiculo(novoVeiculo: Veiculo): Boolean {
        if (isCheio(novoVeiculo.tipo))
            return false

        return getListaDoVeiculo(novoVeiculo.tipo).add(novoVeiculo)
    }

    fun removerVeiculo(placa: String): Boolean {
        val veiculo = getVeiculo(placa)

        if (veiculo is Veiculo)
            return getListaDoVeiculo(veiculo.tipo).removeIf{ it.placa == placa }

        return false
    }
}