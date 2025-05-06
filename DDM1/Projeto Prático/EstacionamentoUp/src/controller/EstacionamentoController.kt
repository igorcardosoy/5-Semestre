package controller

import model.EstacionamentoDAO
import model.report.ReportInHtml
import model.report.ReportInText
import model.veiculo.Veiculo
import model.veiculo.VeiculoEnum
import kotlin.system.exitProcess

class EstacionamentoController {

    fun run() {
        while (true) {
            menu()
        }
    }

    private fun menu() {
        val op = view.menuPrincipal()
        when (op) {
            1 -> verificarPlaca()
            2 -> listarVeiculos()
            else -> exitProcess(1)
        }
    }

    private fun verificarPlaca() {
        val placa = view.solicitarPlaca()

        val veiculo = EstacionamentoDAO.getVeiculo(placa)
        if (veiculo is Veiculo) {
            EstacionamentoDAO.removerVeiculo(placa)
            view.saidaVeiculo(veiculo, EstacionamentoDAO.getPrecoByTipo(veiculo.tipo))
        } else {
            if (!isCheio()) {
                addVeiculo(placa)
            }
        }
    }

    private fun isCheio(): Boolean {
        if (EstacionamentoDAO.isCheio(VeiculoEnum.CARRO) && EstacionamentoDAO.isCheio(VeiculoEnum.MOTO)) {
            view.estacionamentoCheio(null)
            return true
        }

        return false
    }

    private fun addVeiculo(placa: String) {
        val veiculo = view.cadastroVeiculo(placa)
        if (!EstacionamentoDAO.addVeiculo(veiculo)) {
            when (veiculo.tipo) {
                VeiculoEnum.CARRO -> view.estacionamentoCheio(VeiculoEnum.CARRO)
                VeiculoEnum.MOTO -> view.estacionamentoCheio(VeiculoEnum.MOTO)
            }
        }
    }
}

private fun listarVeiculos() {
    val report = when (view.menuRelatorios()) {
        1 -> ReportInText()
        else -> ReportInHtml()
    }

    view.showString(report.getAll(EstacionamentoDAO.carros, EstacionamentoDAO.motos))
}