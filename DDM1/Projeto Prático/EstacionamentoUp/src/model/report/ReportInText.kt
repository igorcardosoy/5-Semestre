package model.report

import model.veiculo.Veiculo

class ReportInText : Report {
    override fun getAll(carros: List<Veiculo>, motos: List<Veiculo>): String {
        val textReport: StringBuilder = StringBuilder()

        textReport.append("---- Carros ----\n")
        carros.forEach {
            textReport.append("Placa: ${it.placa}, Tempo: ${it.getSegundos()} segundos\n")
        }

        textReport.append("\n\n\n")

        textReport.append("---- Motos ----\n")
        motos.forEach {
            textReport.append("Placa: ${it.placa}, Tempo: ${it.getSegundos()} segundos\n")
        }

        return textReport.toString()
    }
}