package model.report

import model.veiculo.Veiculo

interface Report {
    fun getAll(carros: List<Veiculo>, motos: List<Veiculo>): String
}